import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;


//0830. functional interface 사용으로 모두 변경해보기
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public SummaryStatistics summarizeTransactions(){
        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

    public double calculateTotalAmount() {
        return summarizeTransactions((acc, bankTransactions) -> acc+bankTransactions.getAmount());
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransactions) ->
                bankTransactions.getDate().getMonth() == month ? acc + bankTransactions.getAmount() : acc);
    }

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((acc, bankTransactions) -> bankTransactions.getDescription().equals(category) ?
                acc + bankTransactions.getAmount() : acc);
    }

    //특정 날짜 범위
    public double calculateTotalSpecificMonth(final Month start, final Month end) {
        return summarizeTransactions((acc, bankTransactions) ->
                (start.getValue() <= bankTransactions.getDate().getMonth().getValue()
                && bankTransactions.getDate().getMonth().getValue() <= end.getValue())
                ? acc + bankTransactions.getAmount(): acc);
    }

    //특정 범주의 입출금 내역 얻기
    public double calculateTotalSpecificAmount(final int start, final int end) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (start <= bankTransaction.getAmount() && bankTransaction.getAmount() <= end) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    // functional interface 사용
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() > amount);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
