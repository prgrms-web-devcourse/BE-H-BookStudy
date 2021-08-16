package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVFileReader {
    private String filePath;

    public CSVFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Transaction> readCSVFile() throws IOException {
        List<Transaction> transactionList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Transaction transaction = createTransaction(line);
            transactionList.add(transaction);
        }

        bufferedReader.close();

        return transactionList;
    }

    private Transaction createTransaction(String line) {
        StringTokenizer stk = new StringTokenizer(line, ", ");

        LocalDate transactionDate = LocalDate.parse(stk.nextToken(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int transactionValue = Integer.parseInt(stk.nextToken());
        String transactionCategory = stk.nextToken();

        return new Transaction(transactionDate, transactionValue, transactionCategory);
    }
}
