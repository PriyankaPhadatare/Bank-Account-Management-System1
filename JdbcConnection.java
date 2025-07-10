package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/BankAc";
    private static final String USER = "postgres";
    private static final String PASS = "123";

    public static void main(String[] args) {
    	createTable("bank_account");
    }

    static void createTable(String bank_account) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + bank_account + " ("
                    + "id SERIAL PRIMARY KEY, "
                    + "account_number VARCHAR(20), "
                    + "holder_name VARCHAR(100), "
                    + "balance NUMERIC"
                    + ");";

            stmt.execute(createTableQuery);
            System.out.println("Table '" + bank_account + "' has been created successfully on database BankAc.");

        } catch (SQLException e) {
            System.out.println("Error while creating table:");
            e.printStackTrace();
        }
    }
}
