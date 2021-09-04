import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void test(){
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(
                LocalDate.of(2017, Month.JANUARY, 30)
                , -50
                ,"Tesco"
        );
        //0.0d 는 안되: https://stackoverflow.com/questions/53458934/precision-of-junit-5s-assertequals-with-double
        final double tolerance = 0.0d;

        Assertions.assertEquals(result.getDate(), expected.getDate());
        Assertions.assertEquals(result.getDescription(), expected.getDescription());
        Assertions.assertEquals(result.getAmount(), expected.getAmount());
    }
}
