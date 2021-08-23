package com.sezikim.bank.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    public static final String TRANSACTION_FORMAT = "%-20.20s %-20.20s %-20.20s";
    private LocalDate transactionDate;
    private int transactionValue;
    private String transactionContent;

    public Transaction(){}

    public Transaction(LocalDate transactionDate, int transactionValue, String transactionContent) {
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
        this.transactionContent = transactionContent;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionValue() {
        return transactionValue;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    @Override
    public String toString() {
        return String.format(TRANSACTION_FORMAT,
                transactionDate,
                transactionValue,
                transactionContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionValue == that.transactionValue
                && Objects.equals(transactionDate, that.transactionDate)
                && Objects.equals(transactionContent, that.transactionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, transactionValue, transactionContent);
    }
}
