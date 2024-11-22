package DataBaseMySqlTesting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection conn;
    @BeforeMethod
    public Connection setUp() throws SQLException {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseTesting", "root", "Rajupatil@1234");
            } catch (SQLException e) {
                throw new SQLException(e);
            }
  return conn;

    }
@AfterMethod
    public void setClose() throws SQLException {
        conn.close();
    }


}
