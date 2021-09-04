import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//환자의 정보를 담은 리스트를 다큐먼트로 꺼내볼수있도록 구현하였습니다.
public class ImportText implements ImportFile{
    @Override
    public Document importFile(File file) {
        List<Patient> list = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                var patient = Parser.parseLine(line);
                list.add(patient);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Document(list);
    }
}
