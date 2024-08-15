package dbCrud;

import org.example.BaseClass;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurdOperations extends BaseClass {
    @Test
    public void selectQuery() throws SQLException {
        con = this.setUp();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("Select * from Employees");
        while(rs.next()){
            String userId = rs.getString(1);
            String userName = rs.getString(2);
            System.out.println(userId + " " + userName);
        }
    }

    @Test
    public void insertQuery() throws SQLException {
        con = this.setUp();
        try{
            PreparedStatement ps = con.prepareStatement("insert into Employees(EmployeeID, FirstName, LastName, Email, PhoneNumber, HireDate, JobTitle, Salary) values(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1,"6");
            ps.setString(2,"Rohit");
            ps.setString(3,"Jadhav");
            ps.setString(4,"rohit.jadhav@example.com");
            ps.setString(5,"9879543210");
            ps.setString(6,"2024-10-20");
            ps.setString(7,"SDeT");
            ps.setString(8,"25000.00");
            ps.addBatch();
            ps.executeBatch();
            selectQuery();
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    public void deleteQuery() throws SQLException{
        con = this.setUp();
        try{
            PreparedStatement ps = con.prepareStatement("delete from Employees where EmployeeID = 6");
            ps.execute();
        }catch (SQLException e){
            System.out.println("Error in syntax");
            e.printStackTrace();
        }
    }


    @Test
    public void updateQuery() throws SQLException{
        con = this.setUp();
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE Employees SET PhoneNumber = '9998887776' WHERE EmployeeID = 2");
            ps.execute();
            selectQuery();
        }catch (SQLException e){
            System.out.println("Error in syntax");
            e.printStackTrace();
        }
    }

}
