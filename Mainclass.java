package account;

import java.sql.*;
import java.util.Scanner;

public class Mainclass {

    static final String URL = "jdbc:postgresql://localhost:5432/BankAc";
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert " );
            System.out.println("2.Update " );
            System.out.println("3.Delete " );
            System.out.println("4.View " );
            System.out.println("5.Exit " );
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
                if (choice == 1) {
                	 System.out.print("id: ");
                     String id = sc.nextLine();
                	
                    System.out.print("Account Number: ");
                    String acc = sc.nextLine();
                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();
                    String sql = "INSERT INTO bank_account2 (account_number, holder_name, balance) VALUES (?, ?, ?)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, acc);
                        ps.setString(2, name);
                        ps.setDouble(3, bal);
                        ps.executeUpdate();
                        System.out.println("✅ Account added.");
                    }
                } else if (choice == 2) {
                    System.out.print("ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Balance: ");
                    double bal = sc.nextDouble();
                    String sql = "UPDATE bank_account SET holder_name=?, balance=? WHERE id=?";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, name);
                        ps.setDouble(2, bal);
                        ps.setInt(3, id);
                        int rows = ps.executeUpdate();
                        System.out.println(rows > 0 ? "Updated." : "ID not found.");
                    }
                } else if (choice == 3) {
                    System.out.print("ID to delete: ");
                    int id = sc.nextInt();
                    String sql = "DELETE FROM bank_account2 WHERE id=?";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, id);
                        int rows = ps.executeUpdate();
                        System.out.println(rows > 0 ? "Deleted." : " ID not found.");
                    }
                } else if (choice == 4) {
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM bank_account2");
                    System.out.println("\n--- Account List ---");
                    while (rs.next()) {
                        System.out.printf("ID: %d  Acc#: %s Name: %s  Balance: %.2f\n",
                                rs.getInt("id"),
                                rs.getString("account_number"),
                                rs.getString("holder_name"),
                                rs.getDouble("balance"));
                    }
                } else if (choice == 5) {
                    System.out.println(" Exit.");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println(" Database error: " + e.getMessage());
            }
        }

        sc.close();
    }
}



