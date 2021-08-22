package chapter1.vo;

import java.time.LocalDate;

public class Input implements Transaction{
    LocalDate date;
    int money;
    String productName;

    public Input(LocalDate date, int money, String productName) {
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
}
