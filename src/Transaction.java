import java.util.Date;

public class Transaction {
    private double amount;
    private String description;
    private Date date;

    public Transaction(double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.date = new Date();
    }

    public void editTransaction(double amount, String description) {
        // implementation details
    }

    public void deleteTransaction() {
        // implementation details
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }
}