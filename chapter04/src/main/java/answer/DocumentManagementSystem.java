package answer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class DocumentManagementSystem {
    private final List<Document> documentList = new ArrayList<>();

    private final List<Document> documentViews = unmodifiableList(documentList);

    // 파일타입에 대해서 맵으로 관리를 한다
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());
    }

    // non-static block (인스턴스 초기화 블록) : 생성자보다 먼저 호출이 됨. 인스턴스 생성시마다 수행이 됨.
    // https://selfdevelope.tistory.com/607
    // 이 블록이 필요한 이유에 대해서 고민을하다가 찾은 자료: http://tcpschool.com/java/java_member_initBlock
    // 여러 생성자들이 있을 때 이 초기화 블럭을 사용함으로써 여러 생성자에 공통되는 부분을 정의해서 반복코드를 줄일 수 있기 때문이다.
    {
        extensionToImporter.put("invoice", new InvoiceImporter());
    }

    public void importFile(final String path) throws IOException{
        final File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException(path);
        }

        //나는 파일을 그냥 보내놓고 type 을 하나하나 넣어줬었는데 그렇게 하지 않고 확장자 부분의 적합성을 따진다.
        final int separatorIndex = path.lastIndexOf(".");
        if(separatorIndex == -1){
            throw new UnknownFiletypeException("찾을 확장자가 없음" + path);
        }else{
            if(separatorIndex == path.length()){
                throw new UnknownFiletypeException("찾을 확장자 없음" + path);
            }

            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);
            if(importer == null){
                throw new UnknownFiletypeException("바꿔줄 확장자 구현된게 없음" + path);
            }
            final Document document = importer.importFile(file);
            documentList.add(document);
        }
    }

    // read-only: unmodifiableList 는 원본객체의 참조를 끊지 않는다.
    // 따라서 지금 넣어둔 documentList 가 업데이트 되면 업뎃된 정보를 단지 read-only 하는거..!
    public List<Document> contents(){
        return documentViews;
    }

    // 특정 정보가 포함되어있는지 찾는 기능
    // 솔직히 혼자 이렇게 구현하기 힘들거같기는 하지만 언젠가 이렇게 고급지게 코딩해보고 싶다
    public List<Document> search(final String query){
        return documentList
                .stream().filter(Query.parse(query))
                .collect(toList());
    }

}
