package com.paulson.student_db;

public class fee_amount {

    private int amount;

    private int roll;
    public fee_amount(int amount) {
        this.amount = amount;
    }

    public fee_amount()
    {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
