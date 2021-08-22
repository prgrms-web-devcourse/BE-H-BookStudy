package Answer1.legacy;

import Answer1.BankStatementCSVParser;
import Answer1.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementThirdSRP {
    private final static String RESOURCES = "src/main/resources/";

    //first version 에서 SRP 원칙을 적용
    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final String fileName = "data.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFrom(lines);

        System.out.println("The total for all transaction is.. : " + calculateTotalAmount(bankTransactions));
        System.out.println("Transaction in January : " + selectInMonth(bankTransactions, Month.JANUARY));

    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }
        return bankTransactionInMonth;
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
}
