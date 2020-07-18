package Day5.JDBC;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.sql.*;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Login {
    static SQLConnection DBMgr = SQLConnection.getInstance();
    private static Connection con = SQLConnection.getDBConnection();
    private static Statement st = null;

    public static void main(String[] args) {
        boolean cont = true;

        System.out.println(ZonedDateTime.now());
        while (cont) {
            System.out.println("Make a choice (1- Login, 2 - Create Profile, 3 - Update Profile Details, 4 - View Profile, 5 - Exited)");
            Scanner sc = new Scanner(System.in);
            int opt = Integer.parseInt(sc.nextLine());


            switch (opt) {
                case 1:
                    checkLogin();
                    break;
                case 2:
                    createProfile();
                    break;
                case 3:
                    updatePassword();
                    break;
                case 4:
                    viewProfile();
                case 5:
                    cont = false;
                    break;

                default:
                    System.out.println("Please make proper choice!!");
            }
        }
        System.out.println("Exited!!");
    }

    private static void viewProfile() {
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


        String joinQuery = "SELECT * FROM profile INNER JOIN users on profile.userName = users.userName WHERE profile.userName = '" + userName + "'";
        System.out.println(joinQuery);
        try {
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery(joinQuery);
            System.out.println(resultSet.toString());
            if (resultSet.next()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("fname"));
                    System.out.println(resultSet.getString("lname"));
                    System.out.println(resultSet.getString("email"));
                    System.out.println(resultSet.getString("mobileNumber"));
                }

            } else {
                System.out.println("invalid username.!");
            }


//            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void updatePassword() {
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


        System.out.println("Enter password:");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();

        String updateQuery = "Update users set password = '" + pass + "' where userName = '" + userName + "'";

        try {
            st = con.createStatement();
            int res = st.executeUpdate(updateQuery);
            con.commit();
//            con.close();

            if (res == 1) {
                System.out.println("Password for " + userName + " updated.!");
            } else {
                System.out.println(" password not updated.");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createProfile() {
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


        System.out.println("Enter email:");
        scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        System.out.println("Enter password:");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();

        System.out.println("Enter firstname:");
        scanner = new Scanner(System.in);
        String fname = scanner.nextLine();

        System.out.println("Enter lastname:");
        scanner = new Scanner(System.in);
        String lname = scanner.nextLine();

        String createdDate = String.valueOf(ZonedDateTime.now());


        String insertQuery = "INSERT INTO `users`(`userName`, `email`, `password`) " +
                "VALUES ('" + userName + "','" + email + "','" + pass + "');";

        insertQuery = insertQuery + "\n" + "INSERT INTO `profile`(`userName`, `fname`, `lname`, `email`, `mobileNumber`, `gender`, `dateOfBirth`, `profileStatus`, `createdDate`) " +
                "VALUES ('" + userName + "','" + fname + "','" + lname + "','" + lname + "','9876543210','M','01/24/1995','active','" + createdDate + "');";

        try {
            System.out.println(insertQuery);
            st = con.createStatement();
            int res = st.executeUpdate(insertQuery);
            con.commit();

            if (res == 1) {
                System.out.println("User created.");
            } else {
                System.out.println("Record not inserted.");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void checkLogin() {
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


        System.out.println("Enter password:");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        String query = "Select * from users where userName = '" + userName + "' and password = '" + pass + "'";
        try {
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            if (resultSet.next()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("email"));
                }

            } else {
                System.out.println("invalid credentials.!");
            }


//            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
