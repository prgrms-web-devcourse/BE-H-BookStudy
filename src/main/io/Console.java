package main.io;

import main.model.BankStatementProcessor;

public class Console implements Input, Output{

    @Override
    public void printFileError() {
        System.out.println("파일을 읽을 수 없습니다.");
    }

    @Override
    public void printAllIncome(BankStatementProcessor BankStatementProcessor) {
        System.out.println(BankStatementProcessor.getAllIncome());
    }

    @Override
    public void printAllSpending(BankStatementProcessor BankStatementProcessor) {
        System.out.println(BankStatementProcessor.getAllSpending());
    }

    @Override
    public void printTopTenSpending(BankStatementProcessor BankStatementProcessor) {
        System.out.println(BankStatementProcessor.getTopTenSpending());
    }

    @Override
    public void printTopSpending(BankStatementProcessor BankStatementProcessor) {
        System.out.println(BankStatementProcessor.getTopSpending());
    }

    @Override
    public void printMonthlyDetail(BankStatementProcessor BankStatementProcessor, int month) {
        System.out.println(BankStatementProcessor.getMonthlyDetail(month));
    }

    public void printAllRequirements(BankStatementProcessor BankStatementProcessor, int month){
        printAllIncome(BankStatementProcessor);
        printAllSpending(BankStatementProcessor);
        printTopTenSpending(BankStatementProcessor);
        printTopSpending(BankStatementProcessor);
        printMonthlyDetail(BankStatementProcessor, month);
    }
}
