package insertData;

import dbServices.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "INSERT INTO seller (id, name, email, birthDate, baseSalary, departmentId) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, 15);
            ps.setString(2, "Diego");
            ps.setString(3, "di@gmail.com");
            ps.setDate(4, new java.sql.Date(sdf.parse("21/02/1999").getTime()));
            ps.setInt(5, 2500);
            ps.setInt(6, 4);

            //Retorna o numeros de linhas alteradas no bacno
            int rowLines = ps.executeUpdate();
            System.out.println(rowLines);

        }catch (SQLException | ParseException e){
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }


}
