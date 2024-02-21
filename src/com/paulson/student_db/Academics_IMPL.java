package com.paulson.student_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Academics_IMPL implements Academics_INTF{
    Connection con;
    @Override
    public void addReport(Student st) {
        con =DBCONNECTION.createDBConnection();
        String query="insert into academics(roll,cgpa) values(?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            pstm.setInt(2,0);
            int cnt= pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void displayReports() {
        con=DBCONNECTION.createDBConnection();
        String query="select academics.roll,student_info.name,academics.cgpa,academics.percentile from academics join student_info on student_info.roll=academics.roll";
        System.out.println("Student Report :");
        System.out.println("---------------------------------------------");

        System.out.format("%s %6s %10s\n","Roll","Cgpa","Percentile");
        System.out.println("---------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d %6.2f %10.2f\n",
                        result.getInt(1),
                        result.getDouble(2),
                        result.getDouble(3));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void displayRanking() {
        con=DBCONNECTION.createDBConnection();
        String query="select academics.roll,student_info.name,academics.cgpa,academics.percentile,dense_rank() OVER (ORDER BY PERCENTILE DESC) AS 'Rank' from academics join student_info on student_info.roll=academics.roll";
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            System.out.println("---------------------------------------------");
            System.out.format("%s %6s\t%6s\t%10s\t%6s\n","Roll","Name","CGPA","Percentile","Rank");
            System.out.println("---------------------------------------------");
            while (result.next()){
                System.out.format("%d\t%6s\t%6.2f\t%6.2f\t%6d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getDouble(4),
                        result.getInt(5));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateReport(Academics ac) {
        con=DBCONNECTION.createDBConnection();
        String query="update academics set cgpa=? where roll=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setDouble(1,ac.getCgpa());
            pstm.setInt(2,ac.getRoll());
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Report updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteReport(Academics ac) {
        con=DBCONNECTION.createDBConnection();
        String query="delete from academics where roll=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,ac.getRoll());
            pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void displayReportsbasedOnRoll(Academics ac) {
        con=DBCONNECTION.createDBConnection();
        String query="select academics.roll,student_info.name,academics.cgpa,academics.percentile from academics join student_info on student_info.roll=academics.roll where academics.roll=?";
        System.out.println("Student Report :");
        System.out.println("---------------------------------------------");

        System.out.format("%s %6s\t%6s\t%8s\n","Roll","Name","Cgpa","Percentile");
        System.out.println("---------------------------------------------");
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,ac.getRoll());
            ResultSet result= pstm.executeQuery();
            while (result.next()){
                System.out.format("%d\t%6s\t%6.2f\t%6.2f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getDouble(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
