package com.sezikim.bank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sezikim.bank.model.Transaction;

import java.util.List;

public class JsonExporter implements Exporter {
    @Override
    public String exportPeriodTransaction(List<Transaction> transactionList) {
        ObjectMapper mapper = new ObjectMapper();
        String transactionJsonFormat = "";
        try {
            transactionJsonFormat = mapper.registerModule(new JavaTimeModule()).writeValueAsString(transactionList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return transactionJsonFormat;
    }
}
