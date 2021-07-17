package updateData;

import dbServices.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement("UPDATE seller SET baseSalary = baseSalary + ? WHERE departmentId = ?");
            ps.setDouble(1, 250);
            ps.setInt(2, 2);


            int rowLines = ps.executeUpdate();
            System.out.println("row affected: " + rowLines);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
