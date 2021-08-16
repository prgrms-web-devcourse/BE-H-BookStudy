package chapter1;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //일단은 파일을 그냥 하드코딩을 해보았습니다.
        AccountReader accountReader = new AccountReader("data.csv");
        accountReader.fileRead();
    }
}
