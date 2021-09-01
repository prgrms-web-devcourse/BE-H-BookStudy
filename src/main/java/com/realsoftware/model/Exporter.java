package com.realsoftware.model;

import java.util.List;

public interface Exporter {
    void export(List<BankTransaction> bankTransactions, String path);
}
