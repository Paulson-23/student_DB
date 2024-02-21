package com.paulson.student_db;

public class Academics {
    private int roll;
    private double cgpa;

    public Academics(){

    }
    public Academics(int roll, double cgpa) {
        this.roll = roll;
        this.cgpa = cgpa;
    }

    public int getRoll()
    {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Academics{" +
                "roll=" + roll +
                ", cgpa=" + cgpa +
                '}';
    }
}
