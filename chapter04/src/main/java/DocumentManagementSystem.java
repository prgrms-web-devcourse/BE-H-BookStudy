import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class DocumentManagementSystem {

    ImportFile importFile;

    Document document;

    //파일 가져오기 (파일경로, 파일확장자, 이름으로) 가져와 보았습니다.
    void importFile(String path, String type, String name) throws FileNotFoundException {

        //1. 파일 존재 유무 체크
        File file = new File(path + name);
        if(!file.exists()){
            throw new FileNotFoundException(path + "해당 경로에서 파일을 찾을 수 없음");
        }

        //2. 파일의 타입을 체크
        switch (FileType.find(type)){
            case TEXT:
                this.importFile = new ImportText();
                break;
            case IMAGE:
                this.importFile = new ImportImage();
                break;
            case STRING:
                this.importFile = new ImportString();
                break;
            default:
                throw new IllegalArgumentException("잘못된 타입 입력");
        }

        //3. null 체크를 진행했습니다.
        document = importFile.importFile(file);
        if(document == null){
            throw new NullPointerException("관련 문서 찾을 수 없음");
        }
    }

    //다규먼트 리스트
    List<Patient> getPatientInfo(){
        return document.getList();
    }
}
