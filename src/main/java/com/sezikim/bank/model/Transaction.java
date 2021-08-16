package com.sezikim.bank.model;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate transactionDate;
    private final int transactionValue;
    private final String transactionCategory;

    public Transaction(LocalDate transactionDate, int transactionValue, String transactionCategory) {
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
        this.transactionCategory = transactionCategory;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionValue() {
        return transactionValue;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }
}
