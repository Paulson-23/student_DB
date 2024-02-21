package com.paulson.student_db;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int roll;
        String name;
        String dept;
        int year;
        String username;
        String pwd;
        double cgpa;
        String hosteler;
        String quota;
        Academics ac = new Academics();
        Login_details ld = new Login_details();
        User_credentials_INTF login=new User_credentials_IMPL();
        StudentDetails_INTF det = new StudentDetails_IMPL();
        Academics_INTF rep=new Academics_IMPL();
        Fee_info_INTF fee=new Fee_info_IMPL();
        Student st = new Student();
        fee_amount fa=new fee_amount();
        System.out.println("Welcome to Student Management System");
        System.out.println("Are you a Student or a Teacher");
        while(true)
        {
            System.out.println("1. Student \n" +
                    "2. Teacher");
            System.out.println("Choose:");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Welcome Student");
                    System.out.println("Please enter your Roll No:");
                    roll=sc.nextInt();
                    st.setRoll(roll);
                    ac.setRoll(roll);
                    if(det.check(st))
                    {
                        while(true)
                        {
                        System.out.println("What would you like to do:");
                        System.out.println("1. Check the information\n" +
                                "2. Check academic performance\n" +
                                "3. Check fee_details\n" +
                                "4. Exit");
                        System.out.println("Please select your choice:");
                        int option=sc.nextInt();
                            switch (option)
                            {
                                case 1:
                                    det.showStudentBasedonRoll(st);
                                    break;
                                case 2:
                                    rep.displayReportsbasedOnRoll(ac);
                                    break;
                                case 3:
                                    fee.displayFeeBasedOnRoll(st);
                                    break;
                                case 4:
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid choice");
                            }
                        }
                    }
                    break;
                case 2:
                    while (true)
                    {
                        System.out.println("Enter Username : ");
                        username = sc.next();
                        ld.setUsername(username);
                        System.out.println("Enter Password(Default password is your username) : ");
                        pwd = sc.next();
                        ld.setPassword(pwd);
                        if (login.getMaster().equals(ld.getUsername()) && login.getMasterkey().equals(ld.getPassword()))
                        {
                            while (true)
                            {
                                System.out.println("Welcome Principal\n" +
                                        "What would you like to do\n" +
                                        "1. Add User\n" +
                                        "2. View Users\n" +
                                        "3. Remove User\n" +
                                        "4. Exit\n");
                                System.out.println("Enter your choice:");
                                int choose = sc.nextInt();
                                switch (choose)
                                {
                                    case 1:
                                        System.out.println("Enter User to be given access");
                                        username = sc.next();
                                        ld.setUsername(username);
                                        login.addusers(ld);
                                        break;
                                    case 2:
                                        login.viewusers();
                                        break;
                                    case 3:
                                        System.out.println("Enter User whose access is to be removed:");
                                        username = sc.next();
                                        ld.setUsername(username);
                                        login.deleteUser(ld);
                                        break;
                                    case 4:
                                        System.exit(0);
                                }
                            }
                        }
                        else if (login.check(ld))
                        {
                            System.out.println("1. Student Information\n" +
                                    "2. Academics\n" +
                                    "3. Fee Details\n" +
                                    "4. Reset Password");
                            System.out.println("Enter Choice: ");
                            int select = sc.nextInt();
                            while (true) {
                                if (select == 1) {
                                    do {
                                        System.out.println("Student Information\n" +
                                                "1. Add Student\n" +
                                                "2. Show All Students\n" +
                                                "3. Show Student based on roll \n" +
                                                "4. Delete the Student\n" +
                                                "5. Quit");
                                        System.out.println("Enter Choice: ");
                                        int ch = sc.nextInt();
                                        switch (ch)
                                        {
                                            case 1:
                                                System.out.println("Enter Roll : ");
                                                roll = sc.nextInt();
                                                System.out.println("Enter Name ");
                                                name = sc.next();
                                                System.out.println("Enter Department ");
                                                dept = sc.next();
                                                System.out.println("Enter year");
                                                year = sc.nextInt();
                                                System.out.println("Enter MQ/GQ:");
                                                quota=sc.next();
                                                System.out.println("Hosteler(YES/NO)");
                                                hosteler=sc.next();
                                                st.setRoll(roll);
                                                st.setName(name);
                                                st.setDept(dept);
                                                st.setYear(year);
                                                st.setQuota(quota);
                                                st.setHosteler(hosteler);
                                                det.createStudent(st);
                                                rep.addReport(st);
                                                fee.addFeeRecords(st);
                                                break;
                                            case 2:
                                                det.showAllStudents();
                                                break;
                                            case 3:
                                                System.out.println("Enter roll to show the details ");
                                                roll= sc.nextInt();
                                                st.setRoll(roll);
                                                det.showStudentBasedonRoll(st);
                                                break;
                                            case 4:
                                                System.out.println("Enter the roll to delete");
                                                roll = sc.nextInt();
                                                st.setRoll(roll);
                                                ac.setRoll(roll);
                                                rep.deleteReport(ac);
                                                fee.deleteFeeRecord(st);
                                                det.deleteStudent(st);
                                                break;
                                            case 5:
                                                System.exit(0);
                                            default:
                                                System.out.println("Enter valid choice !");
                                                break;
                                        }
                                    }
                                    while (true);
                                }
                                else if (select == 2)
                                {
                                    do {
                                        System.out.println("Academic Reports:\n" +
                                                "1. Update Reports\n" +
                                                "2. Display Reports\n" +
                                                "3. Display Ranking of Students\n" +
                                                "4. Quit");
                                        System.out.println("Enter Choice: ");
                                        int ch2 = sc.nextInt();
                                        switch (ch2) {
                                            case 1:
                                                System.out.println("Enter roll to update the details");
                                                roll = sc.nextInt();
                                                ac.setRoll(roll);
                                                System.out.println("Enter the new cgpa");
                                                cgpa = sc.nextDouble();
                                                ac.setCgpa(cgpa);
                                                rep.updateReport(ac);
                                                break;
                                            case 2:
                                                rep.displayReports();
                                                break;
                                            case 3:
                                                rep.displayRanking();
                                                break;
                                            case 4:
                                                System.exit(0);
                                            default:
                                                System.out.println("Enter valid choice !");
                                                break;
                                        }
                                    } while (true);
                                }
                                else if(select==3)
                                {
                                    while(true)
                                    {
                                        System.out.println("Welcome to Fee details tab\n" +
                                                "What would you like to do");
                                        System.out.println("1. View Fee Details\n" +
                                                "2. View defaulters List\n" +
                                                "3. Update fee payment amount\n" +
                                                "4. Exit");
                                        System.out.println("Select your choice");
                                        int choose = sc.nextInt();
                                        switch(choose)
                                        {
                                            case 1:
                                                fee.displayFee();
                                                break;
                                            case 2:
                                                fee.getNotPaidList();
                                                break;
                                            case 3:
                                                System.out.println("Enter Roll_No:");
                                                roll=sc.nextInt();
                                                fa.setRoll(roll);
                                                System.out.println("Enter amount paid");
                                                int amount=sc.nextInt();
                                                fa.setAmount(amount);
                                                fee.updateFee(fa);
                                                break;
                                            case 4:
                                                System.exit(0);
                                            default:
                                                System.out.println("Invalid option");
                                                break;
                                        }
                                    }
                                }
                                else if(select==4)
                                {
                                    System.out.println("Enter new password");
                                    pwd=sc.next();
                                    ld.setPassword(pwd);
                                    login.resetPassword(ld);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Please check your username and password");
                        }
                    }
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}