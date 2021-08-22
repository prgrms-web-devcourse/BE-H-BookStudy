package com.programmers.java;


import com.programmers.java.io.Console;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String FILE_PATH = "src/resources/withdraw.csv";

    public static void main(String[] args) {
        BankStatementCSVParser bankStatementCSVParser = null;
        Console console = new Console();

        try {
            bankStatementCSVParser = new BankStatementCSVParser(new FileReader(FILE_PATH));
            MoneyAnalyzer moneyAnalyzer = new MoneyAnalyzer(bankStatementCSVParser.parse());
            console.printAllRequirements(moneyAnalyzer, 2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
