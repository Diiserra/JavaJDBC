package firstConnetion;

import dbServices.DB;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();

    }
}
