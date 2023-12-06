/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author iLumniX
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Date;
import java.text.SimpleDateFormat;

import penjualan.koneksi;
import static penjualan.koneksi.conn;

public class PenjualanController {

    private final Connection cn = koneksi.getKoneksi();

    public String Tanggal() {
        SimpleDateFormat formatTanggal = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalSekarang = new Date();
        String tanggal = formatTanggal.format(tanggalSekarang);
        return tanggal;
    }

    public List<String[]> mencariNoFaktur(String noFaktur) {
        List<String[]> dataPenjualan = new ArrayList<>();
        try {
            String query = "SELECT a.NoFaktur, a.TglPenjualan, a.IDPetugas, b.NamaPetugas "
                    + "FROM tblpenjualan AS a "
                    + "JOIN tblpetugas AS b ON b.IDPetugas = a.IDPetugas "
                    + "WHERE a.NoFaktur = ?";

            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, noFaktur);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String NoFaktur = rs.getString("NoFaktur");
                        String TglPenjualan = rs.getString("TglPenjualan");
                        String IdPetugas = rs.getString("IDPetugas");
                        String NamaPetugas = rs.getString("NamaPetugas");
                        String[] data = {NoFaktur, TglPenjualan, IdPetugas, NamaPetugas};
                        dataPenjualan.add(data);
                    }
                    rs.close();
                }
                ps.close();
            }

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return dataPenjualan;
    }
    public Boolean Addnew(String NoFaktur) {
        Boolean check = false;
        String data = null;
        try {
            String query = "SELECT * FROM tblpenjualan WHERE NoFaktur = ?";
            try (PreparedStatement p = cn.prepareStatement(query)) {
                p.setString(1, NoFaktur);
                try (ResultSet r = p.executeQuery()) {
                    if (r.next()) {
                        data = r.getString("NoFaktur");
                    }
                    r.close();
                }
                p.close();
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        if (data != null) {
            check = true;
        }

        return check;
    }

   public List<String[]> IndexPenjualanBarang() {
    List<String[]> dataPenjualan = new ArrayList<>();

    try {
        String query = "SELECT * FROM tblpenjualan";
        String queryDetail = "SELECT a.NoFaktur AS noFaktur, GROUP_CONCAT(b.NamaBarang) AS namaBarang " +
                             "FROM tbldetailpenjualan AS a " +
                             "JOIN tblbarang AS b ON b.KodeBarang = a.KodeBarang " +
                             "WHERE a.NoFaktur = ? " +
                             "GROUP BY a.NoFaktur";

        try (PreparedStatement ps = cn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String noFaktur = rs.getString("NoFaktur");

                // Mengambil data barang pada tbl detail penjualan
                List<String> detail = new ArrayList<>();
                try (PreparedStatement psd = cn.prepareStatement(queryDetail)) {
                    psd.setString(1, noFaktur);
                    try (ResultSet rsd = psd.executeQuery()) {
                        if (rsd.next()) {
                            String namaBarang = rsd.getString("namaBarang");
                            detail.add(namaBarang);
                        }
                    }
                }

                String tglPenjualan = rs.getString("TglPenjualan");
                String idPetugas = rs.getString("IDPetugas");
                String bayar = rs.getString("Bayar");
                String sisa = rs.getString("Sisa");
                String total = rs.getString("Total");

                String[] data = {noFaktur, String.join(", ", detail), tglPenjualan, idPetugas, bayar, sisa, total};
                dataPenjualan.add(data);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dataPenjualan;
}



    public void Store(List<String[]> data, String noFaktur, String tglPenjualan, String idPetugas, String bayar, String sisa, String total) {
        try {
    String query = "INSERT INTO tblpenjualan VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement p = cn.prepareStatement(query)) {
        p.setString(1, noFaktur);
        p.setString(2, tglPenjualan);
        p.setString(3, idPetugas);
        p.setString(4, bayar);
        p.setString(5, sisa);
        p.setString(6, total);
        p.executeUpdate();
    }

    String queryHistory = "INSERT INTO tbldetailpenjualan VALUES (?, ?, ?, ?)";
    String queryUpdateStok = "UPDATE tblbarang SET stok = stok - ? WHERE KodeBarang = ?";

    try (PreparedStatement psHistory = cn.prepareStatement(queryHistory); 
         PreparedStatement psUpdateStok = cn.prepareStatement(queryUpdateStok)) {

        for (String[] v : data) {
            // Insert into tbldetailpenjualan
            psHistory.setString(1, noFaktur);
            psHistory.setString(2, v[0]);
            psHistory.setString(3, v[2]);
            psHistory.setString(4, v[3]);
            psHistory.executeUpdate();

            // Update stock in tblbarang
            psUpdateStok.setString(1, v[2]); // Assuming v[2] contains the quantity to be subtracted from stock
            psUpdateStok.setString(2, v[0]);
            psUpdateStok.executeUpdate();
        }
    }
} catch (SQLException e) {
    System.out.println(e.getMessage());
}

    }

    public void Delete(String noFaktur) {
        try {
            String query = "DELETE FROM tblpenjualan WHERE NoFaktur = ?";
            String query2 = "DELETE FROM tbldetailpenjualan WHERE NoFaktur = ?";
            try (PreparedStatement p = cn.prepareStatement(query)) {
                p.setString(1, noFaktur);
                p.executeUpdate();
                p.close();
            }
            
            try (PreparedStatement ps = cn.prepareStatement(query2)) {
                ps.setString(1, noFaktur);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
     public List<String[]> Cari(String searchNoFaktur) {
    List<String[]> dataPenjualan = new ArrayList<>();

    try {
        // Modify the query to include a WHERE clause for NoFaktur if provided
        String query = "SELECT * FROM tblpenjualan";
        if (searchNoFaktur != null && !searchNoFaktur.isEmpty()) {
            query += " WHERE NoFaktur = ?";
        }

        String queryDetail = "SELECT a.NoFaktur AS noFaktur, GROUP_CONCAT(b.NamaBarang) AS namaBarang " +
                             "FROM tbldetailpenjualan AS a " +
                             "JOIN tblbarang AS b ON b.KodeBarang = a.KodeBarang " +
                             "WHERE a.NoFaktur = ? " +
                             "GROUP BY a.NoFaktur";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            // Set the searchNoFaktur parameter if provided
            if (searchNoFaktur != null && !searchNoFaktur.isEmpty()) {
                ps.setString(1, searchNoFaktur);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String noFaktur = rs.getString("NoFaktur");

                    // Mengambil data barang pada tbl detail penjualan
                    List<String> detail = new ArrayList<>();
                    try (PreparedStatement psd = cn.prepareStatement(queryDetail)) {
                        psd.setString(1, noFaktur);
                        try (ResultSet rsd = psd.executeQuery()) {
                            if (rsd.next()) {
                                String namaBarang = rsd.getString("namaBarang");
                                detail.add(namaBarang);
                            }
                        }
                    }

                    String tglPenjualan = rs.getString("TglPenjualan");
                    String idPetugas = rs.getString("IDPetugas");
                    String bayar = rs.getString("Bayar");
                    String sisa = rs.getString("Sisa");
                    String total = rs.getString("Total");

                    String[] data = {noFaktur, String.join(", ", detail), tglPenjualan, idPetugas, bayar, sisa, total};
                    dataPenjualan.add(data);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dataPenjualan;
}


    }
    
    

