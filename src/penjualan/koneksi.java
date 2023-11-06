package penjualan;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
public class koneksi {
    public static Connection conn;
    
    public static Connection getKoneksi(){
        if(conn==null){
            try{
            String url = "jdbc:mysql://localhost:3306/db_penjualan_barang_pas";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url,user,pass);
            }catch (SQLException e){
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE,null,e);

            }
        }
        return conn;
    }
}
