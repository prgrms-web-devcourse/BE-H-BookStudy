package com.programmers.java;


import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String URL = "C:\\Users\\tlsdy\\Documents\\source\\withdraw.csv";

    public static void main(String[] args) throws IOException {
        CsvParser csvParser = new CsvParser(new FileReader(URL));
        MoneyAnalyzer moneyAnalyzer = new MoneyAnalyzer(csvParser.parse());
        System.out.println(moneyAnalyzer.getAllIncome());
        System.out.println(moneyAnalyzer.getAllSpending());
        System.out.println(moneyAnalyzer.getTopTenSpending().toString());
        System.out.println(moneyAnalyzer.getTopSpending());
        System.out.println(moneyAnalyzer.getMonthlyDetail(2).toString());
    }
}
