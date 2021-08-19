package com.programmers.java;


import com.programmers.java.io.Console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String FILE_PATH = "src/resources/withdraw.csv";

    public static void main(String[] args) {
        CsvParser csvParser = null;
        Console console = new Console();

        try {
            csvParser = new CsvParser(new FileReader(FILE_PATH));
            MoneyAnalyzer moneyAnalyzer = new MoneyAnalyzer(csvParser.parse());
            console.printAllRequirements(moneyAnalyzer, 2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
