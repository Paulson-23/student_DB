package com.paulson.student_db;

public interface User_credentials_INTF {

    public void addusers(Login_details ld);
    public void deleteUser(Login_details ld);
    public void viewusers();
    public boolean check(Login_details ld);
    public void resetPassword(Login_details ld);

    Object getMaster();

    Object getMasterkey();
}
