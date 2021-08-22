package main;

import main.model.BankTransaction;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
    private final static DateTimeFormatter DATE_FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final String COMMA_DELIMITER = ",";

    public List<BankTransaction> parse(List<String> lines) throws IOException {
        List<BankTransaction> transactionDetails = new ArrayList<>();
        for (var line: lines){
            String[] tokens = line.split(COMMA_DELIMITER);
            LocalDate date = LocalDate.parse(tokens[0], DATE_FOMATTER);
            transactionDetails.add(new BankTransaction(date, Long.parseLong(tokens[1]), tokens[2]));
        }
        return transactionDetails;
    }
}
