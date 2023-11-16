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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Connection Database
import penjualan.koneksi;

public class PetugasController {

    private final Connection cn = koneksi.getKoneksi();

    public List<String[]> Index() {
        List<String[]> dataPetugas = new ArrayList<>();
        try {
            String query = "SELECT * FROM tblpetugas";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String IDPetugas = rs.getString("IDPetugas");
                        String NamaPetugas = rs.getString("NamaPetugas");
                        String Alamat = rs.getString("Alamat");
                        String Email = rs.getString("Email");
                        String Telepon = rs.getString("Telepon");
                        String[] data = {IDPetugas, NamaPetugas, Alamat, Email, Telepon};
                        dataPetugas.add(data);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return dataPetugas;
    }

    public String autoKodePetugas() {
        String kodePetugas = null;
        try {
            String query = "SELECT COUNT(IDPetugas) FROM tblpetugas";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        int count = rs.getInt(1) + 1;
                        String kodeDepan = "KP";
                        kodePetugas = String.format("%s%03d", kodeDepan, count);
                    }

                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return kodePetugas;
    }

    public void Store(String NamaPetugas, String Alamat, String Email, String Telepon) {
        try {
            String query = "INSERT INTO tblpetugas(IDPetugas, NamaPetugas, Alamat, Email, Telepon) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, autoKodePetugas());
                ps.setString(2, NamaPetugas);
                ps.setString(3, Alamat);
                ps.setString(4, Email);
                ps.setString(5, Telepon);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }

    public List<String[]> Show(String IDPetugas) {
        List<String[]> dataPetugas = new ArrayList<>();
        try {
            String query = "SELECT * FROM tblpetugas WHERE IDPetugas = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, IDPetugas);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String IdPetugas = rs.getString("IDPetugas");
                        String NamaPetugas = rs.getString("NamaPetugas");
                        String Alamat = rs.getString("Alamat");
                        String Email = rs.getString("Email");
                        String Telepon = rs.getString("Telepon");
                        String[] data = {IdPetugas, NamaPetugas, Alamat, Email, Telepon};
                        dataPetugas.add(data);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
        return dataPetugas;
    }

    public void Update(String IDPetugas, String NamaPetugas, String Alamat, String Email, String Telepon) {
        try {
            String query = "UPDATE tblpetugas SET NamaPetugas = ?, Alamat = ?, Email = ?, Telepon = ? WHERE IDPetugas = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, NamaPetugas);
                ps.setString(2, Alamat);
                ps.setString(3, Email);
                ps.setString(4, Telepon);
                ps.setString(5, IDPetugas);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }

    public void Delete(String IDPetugas) {
        try {
            String query = "DELETE FROM tblpetugas WHERE IDPetugas = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, IDPetugas);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.print("\n{\n \tCode\t: 500\n \tError\t: Tidak dapat tersambung dengan Controller Petugas\n \tMessage\t: " + e.getMessage() + "\n}\n");
        }
    }
}
