package com.paulson.student_db;

public class Student {
    private int roll;
    private String name;
    private String dept;
    private int year;
    private String quota;

    private String hosteler;

    public Student(){

    }

    public Student(int roll, String name, String dept, int year) {
        this.roll = roll;
        this.name = name;
        this.dept = dept;
        this.year = year;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getHosteler() {
        return hosteler;
    }

    public void setHosteler(String hosteler) {
        this.hosteler = hosteler;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", year=" + year +
                '}';
    }
}
