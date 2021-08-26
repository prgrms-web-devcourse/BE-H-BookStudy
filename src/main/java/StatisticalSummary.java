import java.util.List;

//통계 요약해주는 담당
public class StatisticalSummary {
    private double min;
    private double max;
    private double sum;
    private double average;

    StatisticalSummary(List<BankTransaction> bankTransactions){
        //orElse 를 한 이유: 반환 타입이 Optional 이어서 null 인 경우 처리
        this.min = bankTransactions.stream().mapToDouble(BankTransaction::getAmount).min().orElse(this.min);
        this.max = bankTransactions.stream().mapToDouble(BankTransaction::getAmount).max().orElse(this.max);
        this.sum = bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
        this.average = this.getSum() / bankTransactions.size();
        max = 0D;
    }


    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public double getSum() {
        return this.sum;
    }

    public double getAverage() {
        return this.average;
    }
}