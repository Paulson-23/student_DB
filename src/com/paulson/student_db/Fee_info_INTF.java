package com.paulson.student_db;

public interface Fee_info_INTF {
    public void addFeeRecords(Student st);
    public void updateFee(fee_amount fa);
    public void displayFee();
    public void displayFeeBasedOnRoll(Student st);
    public void getNotPaidList();
    public void deleteFeeRecord(Student st);
}
