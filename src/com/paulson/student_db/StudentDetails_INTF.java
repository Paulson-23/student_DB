package com.paulson.student_db;

public interface StudentDetails_INTF
{
    public void createStudent(Student st);
    public void showAllStudents();
    public void  showStudentBasedonRoll(Student st);
    public void deleteStudent(Student st);
    public boolean check(Student st);
}
