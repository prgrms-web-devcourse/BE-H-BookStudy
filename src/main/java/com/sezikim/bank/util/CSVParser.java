package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements Parser {

    public List<Transaction> parseLinesFrom(List<String> lines) {
        List<Transaction> transactionList = new ArrayList<>();
        for (String line : lines) {
            transactionList.add(parseFrom(line));
        }

        return transactionList;
    }

    /**
     * CSV 라인 한줄을 읽어, 사용자 입출금 내역 객체를 반환하는 메소드
     * @param Line (csv파일 문자열 1 Line)
     * @return Transaction
     */
    public Transaction parseFrom(String line) {
        String[] params = line.split(", ");
        LocalDate transactionDate = LocalDate.parse(params[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int transactionValue = Integer.parseInt(params[1]);
        String transactionContent = params[2];

        return new Transaction(transactionDate, transactionValue, transactionContent);
    }
}
