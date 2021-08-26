package com.realsoftware.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


class JsonExporterTest {

    private final Exporter exporter = new JsonExporter();
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    @DisplayName("json 파일 출력 기능")
    void exportFile() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<String> list = new ArrayList<>();
        String testLine1 = "30-01-2017,-100,Deliveroo";
        String testLine2 = "30-01-2017,-50,Tesco";
        String testLine3 = "30-02-2017,6000,Salary";
        String testLine4 = "30-02-2017,2000,Royalties";
        String testLine5 = "30-03-2017,-4000,Rent";
        String testLine6 = "30-02-2017,3000,Tesco";
        String testLine7 = "30-02-2017,-30,Cinema";

        list.add(testLine1);
        list.add(testLine2);
        list.add(testLine3);
        list.add(testLine4);
        list.add(testLine5);
        list.add(testLine6);
        list.add(testLine7);

        List<BankTransaction> bankTransactionList = bankStatementParser.parse(list);
        exporter.export(bankTransactionList, "src/test/resources/");
        List<BankTransaction> testBankTransactionList = null;

        try {
            testBankTransactionList = mapper.readValue(
                Files.readAllBytes(Path.of("src/test/resources/test.json")), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(testBankTransactionList, bankTransactionList);
    }
}