package com.realsoftware.io;


import com.realsoftware.model.BankStatementProcessor;

public interface Output {
    void printFileError();
    void printAllIncome(BankStatementProcessor BankStatementProcessor);
    void printAllSpending(BankStatementProcessor BankStatementProcessor);
    void printTopTenSpending(BankStatementProcessor BankStatementProcessor);
    void printTopSpending(BankStatementProcessor BankStatementProcessor);
    void printMonthlyDetail(BankStatementProcessor BankStatementProcessor, int month);

}
