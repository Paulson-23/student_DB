package com.paulson.student_db;

public class Login_details {

    private String username;

    private String password;

    public Login_details(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login_details() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
