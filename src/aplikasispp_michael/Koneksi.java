/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasispp_michael;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alfon
 */
public class Koneksi {
    public static Connection fungsiKoneksi() throws SQLException{
        Connection conn = null;
//        String driver = "com.mysql.jdbc.Driver";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/aplikasispp_michael";
        String user = "root";
        String pass = "";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi Gagal");
        }
        return conn;
    }
}
