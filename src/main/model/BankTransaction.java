package main.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankTransaction {

    private LocalDate date;
    private long money;
    private String location;

    public BankTransaction(LocalDate date, long money, String location) {
        this.date = date;
        this.money = money;
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getMoney() {
        return money;
    }

    public String getLocation() {
        return location;
    }
}
