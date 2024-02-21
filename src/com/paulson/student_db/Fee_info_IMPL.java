package com.paulson.student_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fee_info_IMPL implements Fee_info_INTF
{
    Connection con;
    @Override
    public void addFeeRecords(Student st) {
        con=DBCONNECTION.createDBConnection();
        String query="insert into fee_info(ROLL_NO,TUITION_FEE,HOSTEL_FEE,FEE_PAID) values(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            if(st.getQuota().equalsIgnoreCase("mq"))
            {
                pstm.setInt(2,150000);
            }
            else
            {
                pstm.setInt(2,85000);
            }
            if(st.getHosteler().equalsIgnoreCase("YES"))
            {
                pstm.setInt(3,85000);
            }
            else {
                pstm.setInt(3, 0);
            }
            pstm.setInt(4,0);
            long cnt= pstm.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateFee(fee_amount fa) {
        con=DBCONNECTION.createDBConnection();
        String query="update fee_info set fee_paid=? where roll_no=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,fa.getAmount());
            pstm.setInt(2,fa.getRoll());
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Fee Updated Successfully");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void displayFee() {
        con=DBCONNECTION.createDBConnection();
        String query="select student_info.name as 'NAME',fee_info.* from fee_info join student_info on student_info.roll=fee_info.roll_no";
        System.out.println("Fee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%10s\t%6s\t%10s\t%6s\t%6s\t%6s\n","Name","Roll","Tuition Fee","Hostel Fee","Total Fee","Fee Paid","Fee Due");
        System.out.println("---------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%10d\t%6d\t%10d\t%10d\t%10d\t%7d\n",
                        result.getString(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6),
                        result.getInt(7));
                System.out.println("---------------------------------------------");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void displayFeeBasedOnRoll(Student st) {
        con=DBCONNECTION.createDBConnection();
        String query="select student_info.name as 'NAME',fee_info.* from fee_info join student_info on student_info.roll=fee_info.roll_no where fee_info.roll_no=?";

        System.out.format("%s\t%10s\t%6s\t%10s\t%6s\t%6s\t%6s\n","Name","Roll","Tuition Fee","Hostel Fee","Total Fee","Fee Paid","Fee Due");
        System.out.println("----------------------------------------------------------------------");
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            ResultSet result= pstm.executeQuery();
            while (result.next()){
                System.out.format("%s\t%8d\t%6d\t%10d\t%10d\t%10d\t%7d\n",
                        result.getString(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6),
                        result.getInt(7));
                System.out.println("------------------------------------------------------------------------");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void getNotPaidList() {
        con=DBCONNECTION.createDBConnection();
        String query="select student_info.name as 'NAME',fee_info.* from fee_info join student_info on student_info.roll=fee_info.roll_no where fee_info.fee_due>0";
        System.out.println("Defaulters List:");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%10s\t%6s\t%10s\t%6s\t%6s\t%6s\n","Name","Roll","Tuition Fee","Hostel Fee","Total Fee","Fee Paid","Fee Due");
        System.out.println("---------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%8d\t%6d\t%10d\t%10d\t%10d\t%7d\n",
                        result.getString(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6),
                        result.getInt(7));
                System.out.println("---------------------------------------------");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void deleteFeeRecord(Student st)
    {
        con=DBCONNECTION.createDBConnection();
        String query="delete from fee_info where roll_no=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,st.getRoll());
            pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}