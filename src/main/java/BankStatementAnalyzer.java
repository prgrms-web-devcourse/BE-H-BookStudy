import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    //export file(현재는 text 로 강하게 결합되어있음)
    public void export(String fileName, BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final var statisticsSummary = new StatisticalSummary(bankTransactions);

        Export exportText= new ExportText(statisticsSummary);
        Export htmlText = new ExportHtml(statisticsSummary);
        Export jsonFile = new ExportJson(statisticsSummary);

        exportText.export();
        htmlText.export();
        jsonFile.export();
    }

    public static void collectSummary(BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transaction is.. : " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transaction in JANUARY : " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transaction in FEBRUARY : " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
