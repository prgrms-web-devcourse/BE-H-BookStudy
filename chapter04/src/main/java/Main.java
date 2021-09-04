import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/";

        try {
            //일단은 text 파일만 구현 하였습니다.
            new DocumentManagementSystem().importFile(path, "text", "Patient.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
