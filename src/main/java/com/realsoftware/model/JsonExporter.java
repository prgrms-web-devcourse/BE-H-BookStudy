package com.realsoftware.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonExporter implements FileExporter{

    @Override
    public void exportFile(List<BankTransaction> bankTransactions, String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), bankTransactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
