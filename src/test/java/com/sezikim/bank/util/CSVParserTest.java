package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {
    private final Parser parser = new CSVParser();


    @Test
    void parseLinesFrom() {
        //given
        List<String> list = new ArrayList<>();
        String line1 = "30-01-2017, -500, Tesco";
        String line2 = "30-01-2017, 1000, Movie";
        list.add(line1);
        list.add(line2);

        //when
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        //then
        assertEquals(transactionList.size(), 2);
    }

    @Test
    void parseFrom() {
        //given
        String line = "30-01-2017, -50, Tesco";
        Transaction expected = new Transaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        //when
        Transaction result = parser.parseFrom(line);

        //then
        assertEquals(expected, result);
    }
}