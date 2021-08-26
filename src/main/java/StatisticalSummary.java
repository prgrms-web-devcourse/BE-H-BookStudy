import java.util.List;

//통계 요약해주는 담당
public class StatisticalSummary {
    private double min;
    private double max;
    private double sum;
    private double average;
    private List<BankTransaction> bankTransactions;

    StatisticalSummary(List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
    }

    public double getMin() {
        for(BankTransaction bankTransaction: bankTransactions){
            this.min = Math.min(min, bankTransaction.getAmount());
        }
        return this.min;
    }

    public double getMax() {
        for(BankTransaction bankTransaction: bankTransactions){
            this.max = Math.max(max, bankTransaction.getAmount());
        }
        return this.max;

    }

    public double getSum() {
        for(BankTransaction bankTransaction: bankTransactions){
            this.sum += bankTransaction.getAmount();
        }
        return this.sum;
    }

    public double getAverage() {
        return this.getSum() / bankTransactions.size();
    }
}
