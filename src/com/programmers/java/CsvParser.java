package com.programmers.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {
    private static final String COMMA_DELIMITER = ",";
    private BufferedReader csvBufferReader;

    public CsvParser(FileReader file) {
        csvBufferReader = new BufferedReader(file);
    }

    public List<List<String>> parse() throws IOException {
        List<List<String>> arrayList = new ArrayList<>();
        String line = "";
        while((line = csvBufferReader.readLine()) != null){
            String[] tokens = line.split(COMMA_DELIMITER);
            arrayList.add(Arrays.asList(tokens));
        }

        return arrayList;
    }
}
