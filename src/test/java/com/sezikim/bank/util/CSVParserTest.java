package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {
    private final Parser parser = new CSVParser();

    @Test
    public void 한줄_잘_읽는지_테스트() throws Exception {
        String line = "30-01-2017, -50, Tesco";
        Transaction expected = new Transaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        Transaction result = parser.parseFrom(line);

        assertEquals(expected, result);
    }
}