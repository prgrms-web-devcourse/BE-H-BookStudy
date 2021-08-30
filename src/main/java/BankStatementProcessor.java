import java.time.Month;
import java.util.List;


// 여기서는 계산하는 역할만 맡는다!
// 모든 연산에서 메서드 인수인 입출금 내역 목록을 공유하니까 이를 클래스의 필드로 만든다.
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    //특정 날짜 범위
    public double calculateTotalSpecificMonth(final Month start, final Month end) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (start.getValue() <= bankTransaction.getDate().getMonth().getValue()
                    && bankTransaction.getDate().getMonth().getValue() <= end.getValue()) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    //특정 범주의 입출금 내역 얻기
    public double calculateTotalSpecificAmount(final int start, final int end) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (start <= bankTransaction.getAmount() && bankTransaction.getAmount() <= end) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

}
