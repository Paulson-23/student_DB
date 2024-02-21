package com.paulson.student_db;

public interface Academics_INTF {
    public void addReport(Student st);
    public void displayReports();
    public void  displayRanking();
    public void updateReport(Academics ac);
    public void deleteReport(Academics ac);
    public void displayReportsbasedOnRoll(Academics ac);
}
