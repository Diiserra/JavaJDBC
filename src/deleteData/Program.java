package deleteData;

import dbServices.DB;
import dbServices.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement("DELETE from department WHERE id = ?");
            ps.setDouble(1, 3);

            int rowLines = ps.executeUpdate();
            System.out.println("row affected: " + rowLines);
        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
