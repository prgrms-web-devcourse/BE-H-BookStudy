package Answer1.legacy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementFirstVersion {
    private static final String RESOURCES = "src/main/resources/";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //KISS 원칙으로 만들어보기 모든 기능 한 클래스에 때려박기
    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);

        total = 0;
        for (final String line : lines) {

            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);

            final double amount = Double.parseDouble(columns[1]);
            total += amount;

        }

        System.out.println("The total for all transactions in January is " + total);

    }
}
