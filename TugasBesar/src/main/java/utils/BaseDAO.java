package utils;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import models.Admin;
import models.Kontraktor;
import models.Pembeli;
import models.Pengguna;

public class BaseDAO {

    protected static final String DB_NAME = "revisi";
    protected static final String DB_HOST = "localhost";
    protected static final String DB_USER = "root";
    protected static final String DB_PASS = "Tanaman123%";
    static Connection conn;
    public Statement st;

    public static Connection getCon() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeCon(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pembeli login(String email, String sandi) throws SQLException  {
        Pembeli akun = null;
        String query = "Select * FROM pengguna WHERE email='%s' AND password='%s'";
        query = String.format(query, email, sandi);
        st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            akun = new Pembeli(
                    rs.getInt("idUSer"),
                    rs.getString("nama"),
                    rs.getString("noHP"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getTimestamp("tanggalDaftar"),
                    rs.getString("tipePengguna")){};
        } else {
            System.out.println("Data tidak ditemukan");
            akun = new Pembeli(0,"Undefined"){};
        }
        return akun;
    }
}
