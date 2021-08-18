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

    /**
     * CSV 라인 한줄을 읽어, 사용자 입출금 내역 객체를 반환하는 메소드
     * @param Line (csv파일 문자열 1 Line)
     * @return Transaction
     */
    private Transaction createTransaction(String line) {
        String[] params = line.split(", ");
        LocalDate transactionDate = LocalDate.parse(params[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int transactionValue = Integer.parseInt(params[1]);
        String transactionContent = params[2];

        return new Transaction(transactionDate, transactionValue, transactionContent);
    }
}
