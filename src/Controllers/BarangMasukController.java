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
import java.util.Date;

import java.text.SimpleDateFormat;
import java.lang.StringBuilder;

import penjualan.koneksi;
import Controllers.BarangController;

public class BarangMasukController {

    private final Connection cn = koneksi.getKoneksi();

    public String Tanggal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalSekarang = new Date();
        String tanggalMasuk = dateFormat.format(tanggalSekarang);
        return tanggalMasuk;
    }

        public Boolean mencariNoNota(String NoNota) {
        Boolean check = false;
        String data = null;
        try {
            String query = "SELECT * FROM tblbrgmasuk WHERE NoNota = ?";
            try (PreparedStatement p = cn.prepareStatement(query)) {
                p.setString(1, NoNota);
                try (ResultSet r = p.executeQuery()) {
                    if (r.next()) {
                        data = r.getString("NoNota");
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

    public List<String[]> Index() {
        List<String[]> dataBrgMasuk = new ArrayList<>();
        try {
            String query = "SELECT a.*, b.NamaPetugas, c.NamaDistributor FROM tblbrgmasuk AS a "
                    + "JOIN tblpetugas AS b ON b.IDPetugas = a.IDPetugas "
                    + "JOIN tbldistributor AS c ON c.IDDistributor = a.IDDistributor";

            String queryHistory = "SELECT b.NamaBarang FROM tbldetailbarangmasuk AS a "
                    + "JOIN tblbarang AS b ON b.KodeBarang = a.KodeBarang "
                    + "WHERE a.NoNota = ?";

            try (PreparedStatement ps = cn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String noNota = rs.getString("NoNota");
                        try (PreparedStatement psb = cn.prepareStatement(queryHistory)) {
                            psb.setString(1, noNota);
                            try (ResultSet rsb = psb.executeQuery()) {
                                List<String> detail = new ArrayList<>();

                                while (rsb.next()) {
                                    String namaBarang = rsb.getString("NamaBarang");
                                    detail.add(namaBarang);
                                }

                                StringBuilder sb = new StringBuilder();

                                // Mengubah array menjadi String gabungan
                                for (String dataNamaBarang : detail) {
                                    sb.append(dataNamaBarang).append(", ");
                                }

                                // Menghapus ekstra
                                if (sb.length() > 0) {
                                    sb.setLength(sb.length() - 2);
                                }

                                String namaBarang = sb.toString();
                                String tglMasuk = rs.getString("TglMasuk");
                                String namaDistributor = rs.getString("NamaDistributor");
                                String namaPetugas = rs.getString("NamaPetugas");
                                String Total = rs.getString("Total");

                                String[] data = {noNota, namaBarang, tglMasuk, namaDistributor, namaPetugas, Total};
                                dataBrgMasuk.add(data);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return dataBrgMasuk;
    }
    
    public List<String[]> Show(String NoNota) {
        List<String[]> dataBrgMasuk = new ArrayList<>();
        try {
            String query = "SELECT a.*, b.NamaPetugas, c.NamaDistributor FROM tblbrgmasuk AS a "
                    + "JOIN tblpetugas AS b ON b.IDPetugas = a.IDPetugas "
                    + "JOIN tbldistributor AS c ON c.IDDistributor = a.IDDistributor "
                    + "WHERE a.NoNota = ?";

            String queryHistory = "SELECT b.NamaBarang FROM tbldetailbarangmasuk AS a "
                    + "JOIN tblbarang AS b ON b.KodeBarang = a.KodeBarang "
                    + "WHERE a.NoNota = ?";

            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, NoNota);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String noNota = rs.getString("NoNota");
                        try (PreparedStatement psb = cn.prepareStatement(queryHistory)) {
                            psb.setString(1, noNota);
                            try (ResultSet rsb = psb.executeQuery()) {
                                List<String> detail = new ArrayList<>();

                                while (rsb.next()) {
                                    String namaBarang = rsb.getString("NamaBarang");
                                    detail.add(namaBarang);
                                }

                                StringBuilder sb = new StringBuilder();

                                // Mengubah array menjadi String gabungan
                                for (String dataNamaBarang : detail) {
                                    sb.append(dataNamaBarang).append(", ");
                                }

                                // Menghapus ekstra
                                if (sb.length() > 0) {
                                    sb.setLength(sb.length() - 2);
                                }

                                String namaBarang = sb.toString();
                                String tglMasuk = rs.getString("TglMasuk");
                                String namaDistributor = rs.getString("NamaDistributor");
                                String namaPetugas = rs.getString("NamaPetugas");
                                String Total = rs.getString("Total");

                                String[] data = {noNota, namaBarang, tglMasuk, namaDistributor, namaPetugas, Total};
                                dataBrgMasuk.add(data);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return dataBrgMasuk;
    }

    public void Store(List<String[]> data, String NoNota, String tglMasuk, String idPetugas, String idDistributor, String Total) {
        try {
            String queryBrgMasuk = "INSERT INTO tblbrgmasuk(NoNota, TglMasuk, IDPetugas, IDDistributor, Total) "
                    + "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = cn.prepareStatement(queryBrgMasuk)) {
                ps.setString(1, NoNota);
                ps.setString(2, tglMasuk);
                ps.setString(3, idPetugas);
                ps.setString(4, idDistributor);
                ps.setString(5, Total);
                ps.executeUpdate();
                ps.close();
            }

            String queryStok = "UPDATE tblbarang SET Stok = ? WHERE KodeBarang = ?";
            String queryHistory = "INSERT INTO tbldetailbarangmasuk(NoNota, KodeBarang, Jumlah, Subtotal) "
                    + "VALUES (?, ?, ?, ?)";
            for (String[] v : data) {
                try (PreparedStatement p = cn.prepareStatement(queryHistory)) {
                    p.setString(1, NoNota);
                    p.setString(2, v[0]);
                    p.setString(3, v[2]);
                    p.setString(4, v[3]);
                    p.executeUpdate();
                    p.close();
                }
                
//                int stok = Integer.parseInt(v[2]);
//                try (PreparedStatement pst = cn.prepareStatement(queryStok)) {
//                    pst.setString(1, Integer.toString(stok));
//                    pst.setString(2, v[0]);
//                }
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void Delete(String noNota) {
        try {
            String query = "DELETE FROM tblbrgmasuk WHERE NoNota = ?";
            String query2 = "DELETE FROM tbldetailbarangmasuk WHERE NoNota = ?";
            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, noNota);
                ps.executeUpdate();
                ps.close();
            }

            try (PreparedStatement ps2 = cn.prepareStatement(query2)) {
                ps2.setString(1, noNota);
                ps2.executeUpdate();
                ps2.close();
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public List<String[]> searchByNoNota(String NoNota) {
    List<String[]> searchData = new ArrayList<>();

    try {
        String query = "SELECT a.NoNota, a.TglMasuk, c.NamaDistributor, b.NamaPetugas, a.Total " +
                "FROM tblbrgmasuk AS a " +
                "JOIN tblpetugas AS b ON b.IDPetugas = a.IDPetugas " +
                "JOIN tbldistributor AS c ON c.IDDistributor = a.IDDistributor " +
                "WHERE a.NoNota = ?";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, NoNota);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String noNota = rs.getString("NoNota");
                    String tglMasuk = rs.getString("TglMasuk");
                    String namaDistributor = rs.getString("NamaDistributor");
                    String namaPetugas = rs.getString("NamaPetugas");
                    String total = rs.getString("Total");

                    if (NoNota.equals(noNota)) { // Memeriksa apakah NoNota sesuai
                        String[] searchDataArray = {noNota, tglMasuk, namaDistributor, namaPetugas, total};
                        searchData.add(searchDataArray);
                    }
                }
            }
        }
    } catch (SQLException e) {
        System.out.print(e.getMessage());
    }

    return searchData;
}


    
}
