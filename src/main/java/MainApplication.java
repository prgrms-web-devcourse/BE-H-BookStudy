import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        final Export exporterHtml = new ExportHtml();
        bankStatementAnalyzer.analyze("data.csv", bankStatementParser, exporterHtml);

        final Export exportJson = new ExportJson();
        bankStatementAnalyzer.analyze("data.csv", bankStatementParser, exportJson);

        final Export exportText = new ExportText();
        bankStatementAnalyzer.analyze("data.csv", bankStatementParser, exportText);
    }
}
