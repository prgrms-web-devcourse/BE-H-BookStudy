package com.sezikim.bank.model;

import java.time.LocalDate;

public class Transaction {
    public static final String TRANSACTION_FORMAT = "%-20.20s %-20.20s %-20.20s";
    private final LocalDate transactionDate;
    private final int transactionValue;
    private final String transactionContent;

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
}
