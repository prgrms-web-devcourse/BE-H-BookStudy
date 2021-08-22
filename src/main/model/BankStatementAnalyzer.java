package main;

import main.io.Console;
import main.model.BankStatementCSVParser;
import main.model.BankStatementProcessor;
import main.model.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String FILE_PATH = "src/main/resources/";
    
    public void analyze(String fileName, BankStatementCSVParser bankStatementCSVParser) throws IOException {
        Console console = new Console();
        Path path = Paths.get(FILE_PATH + fileName);
        List<String> lines = Files.readAllLines(path);
        
        List<BankTransaction> bankTransactions = bankStatementCSVParser.parse(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        printAll(console, bankStatementProcessor);
    }

    private void printAll(Console console, BankStatementProcessor bankStatementProcessor) {
        console.printAllRequirements(bankStatementProcessor, 1);
    }
}
