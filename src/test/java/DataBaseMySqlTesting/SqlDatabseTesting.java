package DataBaseMySqlTesting;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabseTesting extends  BaseClass{


    @Test
    public void insertData() throws SQLException {
        try {
            PreparedStatement ptst = conn.prepareStatement(" insert into Employee values(?,?)");
            ptst.setInt(1, 108);
            ptst.setString(2, "sudir");
            ptst.executeUpdate();
        }catch (SQLException e){
            throw new SQLException();
        }
        selectData();

    }

    @Test
    public void selectData() throws  SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Employee");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }

    }
    @Test
    public void updateData()  throws SQLException{
        try {


            PreparedStatement ptst = conn.prepareStatement("update Employee set emp_name=? where userid=?");
            ptst.setString(1, "Rajkumar");
            ptst.setInt(2, 102);

            ptst.executeUpdate();
            selectData();
        }catch (SQLException e){
            throw new SQLException();
        }

    }
    @Test
    public void deleteData() throws SQLException{
        PreparedStatement ptst = conn.prepareStatement("delete from Employee where userid=?");
        ptst.setInt(1, 105);
        ptst.executeUpdate();
        selectData();
    }
}
