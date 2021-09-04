package answer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Text file 로 변경해주는 작업을 담당하는 곳
// Files class 는 static method 로만 구성되어있음. file, dir, etc files 에서 작동됨.
public class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    TextFile(final File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(Attributes.PATH.getAttribute(), file.getPath());
        //Files.lines: Read all lines from a file as a Stream.
        lines = Files.lines(file.toPath()).collect(Collectors.toList());
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    //그게 아니면 정해진 첫번째줄부터 차례로 문자열을 이어서 붙여준다.
    //파일의 모든 라인을 읽어서 차례로 해당 정보를 map으로 관리 (attribute)하고, 어디까지 저장했는지 line을 내보내준다.
    int addLines(
            final int start,
            final Predicate<String> isEnd,
            final String attributeName) {

            // accumulator: 문자열 계속 이어붙여서 이렇게 한듯
            final StringBuilder accumulator = new StringBuilder();
            int lineNumber;
            for(lineNumber = start; lineNumber < lines.size(); lineNumber++){
                final String line = lines.get(lineNumber);
                if(isEnd.test(line)){
                    break;
                }
                accumulator.append(line).append("\n");
            }

            //trim()을 안넣고 테스트한 결과 뒤에 공백이 한줄 더 추가되서 expect 결과랑 달라졌었음
            attributes.put(attributeName, accumulator.toString().trim());
            return lineNumber;
    }

    void addLineSuffix(final String prefix, final String attributeName){
        for(final String line: lines){
            if(line.startsWith(prefix)){
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}
