package com.sezikim.bank.util;

import com.sezikim.bank.model.Transaction;

import java.util.List;

public interface Parser {
    Transaction parseFrom(String line);
    List<Transaction> parseLinesFrom(List<String> lines);
}
