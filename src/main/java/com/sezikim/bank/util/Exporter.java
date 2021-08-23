package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;

import java.util.List;

public interface Exporter {
    String exportPeriodTransaction(List<Transaction> transactionList);
}
