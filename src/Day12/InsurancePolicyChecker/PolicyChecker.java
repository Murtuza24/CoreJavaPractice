package Day12.InsurancePolicyChecker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.MONTHS;

public class PolicyChecker {

    static DBConnection DBMgr = DBConnection.getInstance();
    private static Connection con = DBConnection.getDBConnection();
    private static Statement st = null;
    static ResultSet resultSet;

    static String CustomerID, CustomerName,
            Email,
            CreatedOn,
            PolicyNumber,
            PolicyName,
            PolicyDescription,
            InstallmentAmount,
            MaxYears,
            InterestRate;

    public static void main(String[] args) throws SQLException {
        System.out.println("Enter Customer ID (1, 2): ");
        Scanner sc = new Scanner(System.in);
        String customerId = sc.nextLine();

        System.out.println("Enter Policy Number (1, 2): ");
        sc = new Scanner(System.in);
        String policyNumber = sc.nextLine();

        getPolicyDetails(customerId, policyNumber);
    }

    private static void getPolicyDetails(String customerId, String policyNumber) throws SQLException {
        try {
            String query = "SELECT * FROM `customers` INNER JOIN policy on customers.PolicyNumber = policy.PolicyNumber " +
                    "WHERE customers.CustomerID = '" + customerId + "';";

            System.out.println(query);

            st = con.createStatement();
            resultSet = st.executeQuery(query);

            if (resultSet.next()) {
                CustomerID = resultSet.getString("CustomerID");
                CustomerName = resultSet.getString("CustomerName");
                Email = resultSet.getString("Email");
                CreatedOn = resultSet.getString("CreatedOn");
                PolicyNumber = resultSet.getString("PolicyNumber");
                PolicyName = resultSet.getString("PolicyName");
                PolicyDescription = resultSet.getString("PolicyDescription");
                InstallmentAmount = resultSet.getString("InstallmentAmount");
                MaxYears = resultSet.getString("MaxYears");
                InterestRate = resultSet.getString("InterestRate");

                System.out.println("CustomerID: " + CustomerID);
                System.out.println("CustomerName: " + CustomerName);
                System.out.println("PolicyNumber: " + PolicyNumber);
                System.out.println("Email: " + Email);
                System.out.println("CreatedOn: " + CreatedOn);
                System.out.println("PolicyName: " + PolicyName);
                System.out.println("PolicyDescription: " + PolicyDescription);
                System.out.println("InstallmentAmount: " + InstallmentAmount);
                System.out.println("MaxYears: " + MaxYears);
                System.out.println("InterestRate: " + InterestRate);

                calculatePolicyDetails();

            } else {
                System.out.println("No Such results");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void calculatePolicyDetails() {
        System.out.println("\n-----------------------------------------");
        LocalDate now = LocalDate.now();
        LocalDate policyStartDate = LocalDate.parse(CreatedOn);

        long TotalMonthsUntilNow = policyStartDate.until(now, MONTHS);
        long TotalMonthsRemaining = now.until(policyStartDate.plusYears(Long.parseLong(MaxYears)), MONTHS);
        long TotalInstallments = policyStartDate.until(policyStartDate.plusYears(Long.parseLong(MaxYears)), MONTHS);

        System.out.println("Total installments until now: " + String.valueOf(TotalMonthsUntilNow));
        System.out.println("Total installments remaining: " + String.valueOf(TotalMonthsRemaining));
        System.out.println("Total installments: " + String.valueOf(TotalInstallments));

        float OpeningBalance = 0;
        float ClosingBalance = (OpeningBalance + Float.parseFloat(InstallmentAmount)) * TotalInstallments;

        float interestRate = (float) ((Math.pow((TotalInstallments / 4.0), Float.parseFloat(InterestRate)))
                / Float.parseFloat((InterestRate))
                * (1 + Float.parseFloat(InterestRate)));
//
        System.out.println("interest Rate: : " + interestRate);
        System.out.println("Monthly Installment: " + InstallmentAmount);
        System.out.println("Closing Balance: " + ClosingBalance);

        float interestAmount = (Float.parseFloat(InterestRate) / 100) * Float.parseFloat(InstallmentAmount) * TotalInstallments;
        System.out.println("Total Interest Gained: " + interestAmount);

        float TotalAmount = ClosingBalance + interestAmount;
        System.out.println("Total Amount after " + MaxYears + " Years is: " + TotalAmount);


    }

}
