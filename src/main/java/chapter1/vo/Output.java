package chapter1.vo;

import java.time.LocalDate;

public class Output implements Transaction, Comparable<Output>{
    private LocalDate date;
    private int money;
    private String productName;

    public Output(LocalDate date, int money, String productName) {
        this.date = date;
        this.money = money;
        this.productName = productName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMoney() {
        return money;
    }

    public String getProduct() {
        return productName;
    }

    @Override
    public int compareTo(Output o) {
        return Integer.compare(this.money, o.money);
    }
}
