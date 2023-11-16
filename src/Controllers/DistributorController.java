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
import java.util.List;

// Connectin Database
import penjualan.koneksi;

public class DistributorController {

    private final Connection cn = koneksi.getKoneksi();

    public String autoKodeDistributor() {
        String kodeDistributor = null;
        try {
            String query = "SELECT COUNT(IDDistributor) FROM tbldistributor";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1) + 1;
                        String kodeDepan = "KD";
                        kodeDistributor = String.format("%s%03d", kodeDepan, count);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return kodeDistributor;
    }

    public List<String[]> Index() {
        List<String[]> dataDistributor = new ArrayList<>();
        try {
            String query = "SELECT * FROM tbldistributor";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String IDDistributor = rs.getString("IDDistributor");
                        String NamaDistributor = rs.getString("NamaDistributor");
                        String Alamat = rs.getString("Alamat");
                        String KotaAsal = rs.getString("KotaAsal");
                        String Email = rs.getString("Email");
                        String Telepon = rs.getString("Telepon");
                        String[] data = {IDDistributor, NamaDistributor, Alamat, KotaAsal, Email, Telepon};
                        dataDistributor.add(data);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return dataDistributor;
    }

    public void Store(String NamaDistributor, String Alamat, String KotaAsal, String Email, String Telepon) {
        try {
            String query = "INSERT INTO tbldistributor(IDDistributor, NamaDistributor, Alamat, KotaAsal, Email, Telepon) VAlUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, autoKodeDistributor());
                ps.setString(2, NamaDistributor);
                ps.setString(3, Alamat);
                ps.setString(4, KotaAsal);
                ps.setString(5, Email);
                ps.setString(6, Telepon);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }

    public List<String[]> Show(String IDDistributor) {
        List<String[]> dataDistributor = new ArrayList<>();
        try {
            String query = "SELECT * FROM tbldistributor WHERE IDDistributor = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, IDDistributor);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String IdDistributor = rs.getString("IDDistributor");
                        String NamaDistributor = rs.getString("NamaDistributor");
                        String Alamat = rs.getString("Alamat");
                        String KotaAsal = rs.getString("KotaAsal");
                        String Email = rs.getString("Email");
                        String Telepon = rs.getString("Telepon");
                        String[] data = {IdDistributor, NamaDistributor, Alamat, KotaAsal, Email, Telepon};
                        dataDistributor.add(data);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return dataDistributor;
    }

    public void Update(String IDDistributor, String NamaDistributor, String Alamat, String KotaAsal, String Email, String Telepon) {
        try {
            String query = "UPDATE tbldistributor SET NamaDistributor = ?, Alamat = ?, KotaAsal = ?, Email = ?, Telepon = ? WHERE IDDistributor = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, NamaDistributor);
                ps.setString(2, Alamat);
                ps.setString(3, KotaAsal);
                ps.setString(4, Email);
                ps.setString(5, Telepon);
                ps.setString(6, IDDistributor);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }

    public void Delete(String IDDistributor) {
        try {
            String query = "DELETE FROM tbldistributor WHERE IDDistributor = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, IDDistributor);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Distributor\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }
}
