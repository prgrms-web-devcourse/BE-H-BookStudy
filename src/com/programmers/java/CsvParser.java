package com.programmers.java;

import com.programmers.java.model.MoneyDetail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {
    private static final String COMMA_DELIMITER = ",";
    private final BufferedReader csvBufferReader;

    public CsvParser(FileReader file) {
        csvBufferReader = new BufferedReader(file);
    }

    public List<MoneyDetail> parse() throws IOException {
        List<MoneyDetail> transactionDetails = new ArrayList<>();
        String line = "";
        while((line = csvBufferReader.readLine()) != null){
            String[] tokens = line.split(COMMA_DELIMITER);
            transactionDetails.add(new MoneyDetail(tokens[0], Long.parseLong(tokens[1]), tokens[2]));
        }

        csvBufferReader.close();
        return transactionDetails;
    }
}
