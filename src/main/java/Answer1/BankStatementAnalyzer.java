package Answer1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    public static void main(final String ... args) throws IOException {

        final String fileName = "data.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    public static void collectSummary(BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transaction is.. : " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transaction in JANUARY : " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transaction in FEBRUARY : " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
