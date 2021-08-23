package com.sezikim.bank.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sezikim.bank.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonExporterTest {
    private final Exporter exporter = new JsonExporter();
    private final Parser parser = new CSVParser();

    @Test
    void exportPeriodTransaction() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);
        String s = exporter.exportPeriodTransaction(transactionList);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Transaction> l = objectMapper.registerModule(new JavaTimeModule()).readValue(s, new TypeReference<>() {});
            assertEquals(l, transactionList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
