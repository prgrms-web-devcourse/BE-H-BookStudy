package com.realsoftware.model;

import java.util.List;

public interface FileExporter {
    void exportFile(List<BankTransaction> bankTransactions, String path);
}
