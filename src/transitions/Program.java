package transitions;

import dbServices.DB;
import dbServices.DbExeception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("UPDATE seller set baseSalary = 4400 where departmentId = 1");
            int row = ps.executeUpdate();



            ps = conn.prepareStatement("UPDATE seller set baseSalary = 8888 where departmentId = 2");
            int roow = ps.executeUpdate();

            conn.commit();

            System.out.println(row);
            System.out.println(roow);
        }catch (SQLException e){
            try {
                conn.rollback();
                throw new DbExeception("Houve um erro de transição, sera feito um rollback.");
            } catch (SQLException e1) {
                throw new DbExeception(e.getMessage());
            }
        }finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }


    }
}
