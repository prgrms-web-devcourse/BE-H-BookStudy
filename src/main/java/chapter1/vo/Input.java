package chapter1.vo;

import java.time.LocalDate;

public class Input implements Transaction{
    LocalDate date;
    int money;
    String product;

    public Input(LocalDate date, int money, String product) {
        this.date = date;
        this.money = money;
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMoney() {
        return money;
    }

    public String getProduct() {
        return product;
    }
}
