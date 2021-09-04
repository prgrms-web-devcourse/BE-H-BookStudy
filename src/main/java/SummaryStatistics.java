import java.util.List;

public class SummaryStatistics {
    private double min;
    private double max;
    private double sum;
    private double average;

    //ans: 과제에서 작성
    SummaryStatistics(final double sum, final double max, final double min, final double average){
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
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