package transaction;

import java.time.LocalDate;

import static parser.TransactionParser.dateTimeFormatter;

public class Transaction {
    public static final int NUMBER_OF_PARAMETERS = 5;
    private static int transactionCounter = 1;
    private final String transactionId;
    private final String carLicensePlate;
    private final String customer;
    private final int duration;
    private final LocalDate startDate;
    private boolean isCompleted;

    public Transaction(String carLicensePlate, String customer, int duration,
                       LocalDate startDate) {
        this.transactionId = "TX" + transactionCounter++;
        this.carLicensePlate = carLicensePlate;
        this.customer = customer;
        this.duration = duration;
        this.startDate = startDate;
        this.isCompleted = false;
    }

    public Transaction(String carLicensePlate, String customer, int duration, LocalDate startDate
            , boolean isCompleted) {
        this.transactionId = "TX" + transactionCounter++;
        this.carLicensePlate = carLicensePlate;
        this.customer = customer;
        this.duration = duration;
        this.startDate = startDate;
        this.isCompleted = isCompleted;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    private String durationtoString(){
        if(duration == 1) {
            return " day";
        } else {
            return duration + " days";
        }
    }

    @Override
    public String toString() {
        String formattedDate = startDate.format(dateTimeFormatter);
        if (this.isCompleted) {
            return "[X] " + transactionId + " | " + carLicensePlate + " | " + customer + " | " +
                    durationtoString() + System.lineSeparator() + "Start Date: " + formattedDate;
        } else {
            return "[ ] " + transactionId + " | " + carLicensePlate + " | " + customer + " | " +
                    durationtoString() + System.lineSeparator() + "Start Date: " + formattedDate;
        }
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String toFileString(){
        return this.getCarLicensePlate() + " | " + this.getCustomer() + " | " + this.getDuration() + " | "
                + this.getStartDate().format(dateTimeFormatter) + " | " + this.isCompleted();
    }
}
