package com.sellandrent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionPool {
	private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        try {
            if (dataSource == null) {
                InitialContext initialContext = new InitialContext();
                dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/RentDB");
            }
            return dataSource.getConnection();
        } catch (NamingException e) {
            throw new SQLException("JNDI lookup failed for jdbc/RentDB", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close(); // Bağlantıyı havuza geri verir
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
