package com.realsoftware.model;


import com.realsoftware.io.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String FILE_PATH = "src/main/resources/";
    
    public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {
        Console console = new Console();
        Path path = Paths.get(FILE_PATH + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parse(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        List<BankTransaction> searchBanktransactions = bankStatementProcessor.searchByDateRange(
                LocalDate.of(2017, 1, 30), LocalDate.of(2017, 3, 30));


    }

    private void printAll(Console console, BankStatementProcessor bankStatementProcessor) {
        console.printAllRequirements(bankStatementProcessor, Month.JANUARY);
    }
}
