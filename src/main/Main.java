package main;


import main.model.BankStatementAnalyzer;
import main.model.BankStatementCSVParser;

import java.io.IOException;

public class Main {
    private static final String FILE_PATH = "src/resources/withdraw.csv";

    public static void main(String[] args) {
        BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        try {
            new BankStatementAnalyzer().analyze("withdraw.csv", bankStatementCSVParser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
