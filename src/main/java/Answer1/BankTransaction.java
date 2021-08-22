package Answer1;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    public final String description;

    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankTransaction)) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getDate(), that.getDate()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAmount(), getDescription());
    }
}
