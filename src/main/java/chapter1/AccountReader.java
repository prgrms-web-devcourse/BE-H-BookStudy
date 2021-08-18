package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AccountReader {
    private final static String RESOURCE_PHAT = "src/main/resources/";
    private final String file;
    private final Account account = Account.getInstance();
    private final Print print = new Print();

    public AccountReader(String file) {
        this.file = file;
    }

    public void fileRead() throws IOException {
        String line = null;
        BufferedReader br = new BufferedReader(new java.io.FileReader(RESOURCE_PHAT + file));

        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");

            LocalDate localDate = LocalDate.parse(arr[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            int money = Integer.parseInt(arr[1]);
            String product = arr[2];

            account.addAccountList(localDate, money, product);

        }
        print.print();
    }
}
