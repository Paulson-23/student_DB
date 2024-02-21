package com.paulson.student_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User_credentials_IMPL implements User_credentials_INTF {
    Connection con;
    final private String master = "principal";
    final private String masterkey = "Srishakthi";

    public void addusers(Login_details ld)
    {
        con =DBCONNECTION.createDBConnection();
        String query="insert into user_credentials values(?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,ld.getUsername());
            pstm.setString(2,ld.getUsername());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("User Added Successfully !!!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void deleteUser(Login_details ld)
    {
        con=DBCONNECTION.createDBConnection();
        String query="delete from user_credentials where usernames like ?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,ld.getUsername());
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("User Removed Successfully!!! ");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void viewusers()
    {
        con=DBCONNECTION.createDBConnection();
        String query="select * from user_credentials";
        System.out.println("Users Authorized:");
        System.out.println("----------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\n", result.getString(1));
                System.out.println("----------");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean check(Login_details ld)
    {
        con=DBCONNECTION.createDBConnection();
        String query="select password from user_credentials where usernames=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,ld.getUsername());
            ResultSet result= pstm.executeQuery();
            while(result.next())
            {
                if(result.getString(1).equals(ld.getPassword())) {
                    return true;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public void resetPassword(Login_details ld)
    {
        con=DBCONNECTION.createDBConnection();
        String query="update user_credentials set password=? where usernames=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,ld.getPassword());
            pstm.setString(2,ld.getUsername());
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Password reset was Successful");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public String getMaster() {
        return master;
    }

    public String getMasterkey() {
        return masterkey;
    }
}
