package com.paulson.student_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDetails_IMPL implements StudentDetails_INTF
{
    Connection con;
    @Override
    public void createStudent(Student st) {
        con =DBCONNECTION.createDBConnection();
        String query="insert into student_info values(?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            pstm.setString(2,st.getName());
            pstm.setString(3,st.getDept());
            pstm.setInt(4,st.getYear());
            pstm.setString(5,st.getQuota());
            pstm.setString(6,st.getHosteler());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Inserted Successfully !!!");


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllStudents() {
        con=DBCONNECTION.createDBConnection();
        String query="select * from student_info";
        System.out.println("Student Details :");
        System.out.println("+--------+------------------+--------+-------+--------+----------+");
        System.out.format("| %-6s | %-16s | %-6s | %-5s | %-6s | %-8s |\n","Roll","Name","Dept","Year","Quota","Hosteler");
        System.out.println("+--------+------------------+--------+-------+--------+----------+");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("| %-6d | %-16s | %-6s | %-5d | %-6s | %8s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                        System.out.println("+--------+------------------+--------+-------+--------+----------+");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showStudentBasedonRoll(Student st) {
        con=DBCONNECTION.createDBConnection();
        String query="select * from student_info where roll=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            ResultSet result= pstm.executeQuery();
            System.out.println("+--------+------------------+--------+-------+--------+----------+");
            System.out.format("| %-6s | %-16s | %-6s | %-5s | %-6s | %-8s |\n","Roll","Name","Dept","Year","Quota","Hosteler");
            System.out.println("+--------+------------------+--------+-------+--------+----------+");
            while (result.next()){
                System.out.format("| %-6d | %-16s | %-6s | %-5d | %-6s | %8s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
            }
            System.out.println("+--------+------------------+--------+-------+--------+----------+");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Student st) {
        con=DBCONNECTION.createDBConnection();
        String query="delete from student_info where roll=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Deleted Successfully!!! ");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean check(Student st) {
        con=DBCONNECTION.createDBConnection();
        String query="select roll from student_info where roll=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            ResultSet result=pstm.executeQuery();
            while(result.next())
            {
                if(result.getInt(1)==st.getRoll())
                {
                    return true;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
