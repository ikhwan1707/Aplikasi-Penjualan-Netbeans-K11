/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import penjualan.koneksi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iLumniX
 */
public class BarangController {

    private final Connection cn = koneksi.getKoneksi();

    public String autoKodeBarang() {
        String kodeBarang = null;

        try {
            String query = "SELECT COUNT(KodeBarang) FROM  tblbarang";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1) + 1;
                        String kodeDepan = "KB";
                        kodeBarang = String.format("%s%03d", kodeDepan, count);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return kodeBarang;
    }

    public List<String[]> Index() {
        List<String[]> dataBarang = new ArrayList<>();

        try {
            String query = "SELECT KodeBarang, NamaBarang, HargaNet, HargaJual, Stok, tbljenis.Jenis AS Jenis FROM tblbarang JOIN tbljenis ON tblbarang.KodeJenis = tbljenis.KodeJenis";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String kodeBarang = rs.getString("KodeBarang");
                        String namaBarang = rs.getString("NamaBarang");
                        String hargaNet = rs.getString("HargaNet");
                        String hargaJual = rs.getString("HargaJual");
                        String stok = rs.getString("Stok");
                        String jenis = rs.getString("Jenis");
                        String[] data = {kodeBarang, namaBarang, jenis, hargaNet, hargaJual, stok};
                        dataBarang.add(data);
                    }

                    System.out.print("\n{\n \tCode\t: 200\n \tMessage\t: Data barang Berhasil terpanggil\n }\n");
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return dataBarang;
    }

    public void Store(String namaBarang, String kodeJenis, String hargaNet, String hargaJual, String stok) {
        try {
            String query = "INSERT INTO tblbarang(KodeBarang, NamaBarang, KodeJenis, HargaNet, HargaJual, Stok) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, autoKodeBarang());
                ps.setString(2, namaBarang);
                ps.setString(3, kodeJenis);
                ps.setString(4, hargaNet);
                ps.setString(5, hargaJual);
                ps.setString(6, stok);

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }

    public List<String[]> Show(String kodeBarang) {
        List<String[]> dataBarang = new ArrayList<>();

        try {
            String query = "SELECT * FROM tblbarang WHERE KodeBarang = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, kodeBarang);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String KodeBarang = rs.getString("KodeBarang");
                        String NamaBarang = rs.getString("NamaBarang");
                        String KodeJenis = rs.getString("KodeJenis");
                        String HargaNet = rs.getString("HargaNet");
                        String HargaJual = rs.getString("HargaJual");
                        String Stok = rs.getString("Stok");
                        String[] data = {KodeBarang, NamaBarang, KodeJenis, HargaNet, HargaJual, Stok};
                        dataBarang.add(data);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return dataBarang;
    }

    public void Update(String kodeBarang, String namaBarang, String kodeJenis, String hargaNet, String hargaJual, String stok) {
        try {
            String query = "UPDATE tblbarang SET NamaBarang = ?, KodeJenis = ?, HargaNet = ?, HargaJual = ?, Stok = ? WHERE KodeBarang = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, namaBarang);
                ps.setString(2, kodeJenis);
                ps.setString(3, hargaNet);
                ps.setString(4, hargaJual);
                ps.setString(5, stok);
                ps.setString(6, kodeBarang);

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }
    
    public void UpdateStok(String kodeBarang, String Stok) {
        String stok = null;
        try {
            String queryStok = "SELECT stok FROM tblbarang WHERE KodeBarang = ?";
            try (PreparedStatement ps = cn.prepareStatement(queryStok)) {
                ps.setString(1, kodeBarang);
                try (ResultSet r = ps.executeQuery()) {
                    if (r.next()) {
                        stok = r.getString("stok");
                    }
                    r.close();
                }
                ps.close();
            }
            int jumlahStok = Integer.parseInt(stok) + Integer.parseInt(Stok);
            String query = "UPDATE tblbarang SET Stok = ? WHERE KodeBarang = ?";
            try (PreparedStatement p = cn.prepareStatement(query)) {
                p.setString(1, Integer.toString(jumlahStok));
                p.setString(2, kodeBarang);
                p.executeUpdate();
                p.close();
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void Delete(String kodeJenis) {
        try {
            String query = "DELETE FROM tblbarang where KodeBarang = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, kodeJenis);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: BarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }
}
