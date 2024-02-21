package com.paulson.student_db;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBCONNECTION {
    static Connection con;
    public static Connection createDBConnection(){

        try{
            String url="jdbc:mysql://localhost:3306/sys";
            String username="root";
            String password="010603<3";
            con= DriverManager.getConnection(url,username,password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;

    }
}
