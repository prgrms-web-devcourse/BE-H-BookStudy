package com.realsoftware.model;

import java.util.List;

public interface BankStatementParser {
    List<BankTransaction> parse(List<String> lines);
}
