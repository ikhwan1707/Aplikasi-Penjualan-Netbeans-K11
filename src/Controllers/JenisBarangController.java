/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import penjualan.koneksi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iLumniX
 */
public class JenisBarangController {

    private final Connection cn = koneksi.getKoneksi();

    public String autoKodeJenis() {
        String kodeJenis = null;

        try {
            String query = "SELECT COUNT(KodeJenis) FROM tbljenis";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1) + 1;
                        String kodeDepan = "KJ";
                        kodeJenis = String.format("%s%03d", kodeDepan, count);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return kodeJenis;
    }

    public List<String[]> Index() {
        List<String[]> dataJenisBarang = new ArrayList<>();

        try {
            String query = "SELECT * FROM tbljenis";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String[] data = {rs.getString("KodeJenis"), rs.getString("Jenis")};
                        dataJenisBarang.add(data);
                    }

                    System.out.print("\n{\n \tCode\t: 200\n \tMessage\t: Data jenis Berhasil terpanggil\n }\n");
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return dataJenisBarang;
    }

    public void Store(String jenis) {
        try {
            String query = "INSERT INTO tbljenis (KodeJenis, Jenis) VALUES (?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, autoKodeJenis());
                ps.setString(2, jenis);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }

    public List<String[]> Show(String kodeJenis) {
        List<String[]> dataJenis = new ArrayList<>();

        try {
            String query = "SELECT * FROM tbljenis WHERE KodeJenis = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, kodeJenis);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String[] data = {rs.getString("KodeJenis"), rs.getString("Jenis")};
                        dataJenis.add(data);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }

        return dataJenis;
    }

    public void Update(String kodeJenis, String jenis) {
        try {
            String query = "UPDATE tbljenis SET Jenis = ? WHERE KodeJenis = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, jenis);
                ps.setString(2, kodeJenis);

                ps.executeUpdate();
                System.out.print("\n{\n \tCode\t: 200\n \tMessage\t: Jenis barang berhasil di update\n }\n");
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }

    public void Delete(String kodeJenis) {
        try {
            String query = "DELETE FROM tbljenis WHERE KodeJenis = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, kodeJenis);

                ps.executeUpdate();
                System.out.print("\n{\n \tCode\t: 200\n \tMessage\t: Data jenis barang berhasil terhapus\n }\n");
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("\n{\n\tCode\t: 500\n \tMessage\t: JenisBarangController tidak terhubung dengan database\n \tMessage\t: " + e.getMessage() + " \n}\n");
        }
    }
}
