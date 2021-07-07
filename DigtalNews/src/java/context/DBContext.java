package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {

    private static final String DBNAME = "Digital";
    private static final String SERVERNAME = "localhost";
    private static final String PORTNUMBER = "1433";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + SERVERNAME + ":" + PORTNUMBER + ";databaseName=" + DBNAME;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, USERNAME, PASSWORD);

    }

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getImagePath() throws Exception {
        return "images/";
    }

}
