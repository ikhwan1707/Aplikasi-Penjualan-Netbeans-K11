
package Desain;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.BarangMasukController;
import java.util.List;
import java.sql.*;
import penjualan.koneksi;
import java.util.ArrayList;
import Controllers.BarangController;
import Controllers.PetugasController;
import Controllers.DistributorController;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;
import penjualan.koneksi;
/**
 *
 * @author heru9
 */
public class MenuBrgMasuk extends javax.swing.JPanel {

 private final BarangMasukController b = new BarangMasukController();
    private final PetugasController p = new PetugasController();
    private final BarangController bc = new BarangController();
    private final DistributorController d = new DistributorController();
    private static Connection conn;
    private final DefaultTableModel view = new DefaultTableModel();
    private final DefaultTableModel view2 = new DefaultTableModel();
    private List<String[]> detail = new ArrayList<>();
    public MenuBrgMasuk() {
        initComponents();
         loadData();
        loadDetail();
        conn=koneksi.getKoneksi();
         try {
            TampilId();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        gbt_jenkel = new javax.swing.ButtonGroup();
        PanelMain = new javax.swing.JPanel();
        pn_main = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhasil = new javax.swing.JTable();
        masterdata = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pn_add1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        noNota = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        kota = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        kodePetugas = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        namaPetugas = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        kodeDistributor = new javax.swing.JComboBox<>();
        namaDistributor = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        kodeBarang = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        hargaJual = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        stok = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        subTotal = new javax.swing.JTextField();
        addItem = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        save = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(1387, 768));
        setLayout(new java.awt.CardLayout());

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setPreferredSize(new java.awt.Dimension(976, 708));
        PanelMain.setLayout(new java.awt.CardLayout());

        pn_main.setBackground(new java.awt.Color(255, 255, 255));
        pn_main.setPreferredSize(new java.awt.Dimension(976, 708));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Penjualan");

        tblhasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblhasil);

        masterdata.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        masterdata.setForeground(new java.awt.Color(102, 102, 102));
        masterdata.setText("Master Data > Barang Masuk");
        masterdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterdataMouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/laptop.png"))); // NOI18N

        btntambah.setBackground(new java.awt.Color(51, 51, 255));
        btntambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Hapus");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(255, 102, 0));
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");

        jTextField1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Cari NoNota");

        javax.swing.GroupLayout pn_mainLayout = new javax.swing.GroupLayout(pn_main);
        pn_main.setLayout(pn_mainLayout);
        pn_mainLayout.setHorizontalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(jLabel13)
                                .addGap(268, 268, 268)
                                .addComponent(jLabel15))
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addComponent(btntambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(masterdata))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pn_mainLayout.setVerticalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15)
                        .addComponent(masterdata)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btntambah)
                        .addComponent(btndelete)
                        .addComponent(btnBatal))
                    .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        PanelMain.add(pn_main, "card2");

        pn_add1.setBackground(new java.awt.Color(255, 255, 255));
        pn_add1.setPreferredSize(new java.awt.Dimension(700, 548));

        jPanel8.setBackground(new java.awt.Color(255, 255, 0));
        jPanel8.setPreferredSize(new java.awt.Dimension(700, 548));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel45.setText("Create Barang Masuk");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 30, -1, -1));

        jButton25.setText("Clear");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, 88, 32));

        jButton27.setText("Close");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, 100, 32));

        jLabel47.setText("Tanggal Barang Masuk");
        jPanel8.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 72, -1, -1));

        tanggal.setEnabled(false);
        jPanel8.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 67, 200, -1));

        jLabel48.setText("No. Nota");
        jPanel8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 72, -1, -1));
        jPanel8.add(noNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 67, 120, -1));

        jLabel49.setText("Nama Distributor");
        jPanel8.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 154, -1, -1));
        jPanel8.add(kota, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 200, -1));

        jButton29.setText("AddNew");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jLabel36.setText("ID Petugas");
        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 113, -1, -1));

        kodePetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Petugas" }));
        kodePetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodePetugasActionPerformed(evt);
            }
        });
        jPanel8.add(kodePetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 108, 200, -1));

        jLabel37.setText("Nama Petugas");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 158, -1, 16));
        jPanel8.add(namaPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 149, 200, -1));

        jLabel38.setText("ID Distributor");
        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 113, -1, -1));

        kodeDistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Distributor" }));
        kodeDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeDistributorActionPerformed(evt);
            }
        });
        jPanel8.add(kodeDistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 108, 203, -1));
        jPanel8.add(namaDistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 149, 203, -1));

        jLabel39.setText("Kota Asal");
        jPanel8.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 195, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Barang"));

        kodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Barang" }));
        kodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeBarangActionPerformed(evt);
            }
        });

        jLabel41.setText("Nama Barang");

        jLabel50.setText("Harga Jual");

        hargaJual.setDragEnabled(true);
        hargaJual.setEnabled(false);

        jLabel51.setText("Stok");

        stok.setEnabled(false);

        jLabel52.setText("Jumlah");

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        jLabel53.setText("Sub Total Rp");

        subTotal.setEnabled(false);

        addItem.setText("Add Item");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel54.setText("Kode Barang");

        namaBarang.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kodeBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hargaJual)
                    .addComponent(namaBarang))
                .addGap(187, 187, 187)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitung))
                            .addComponent(subTotal)))
                    .addComponent(addItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hitung)
                        .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(hargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 780, -1));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(dataTable);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 440, 786, 141));

        save.setText("Save Transaction");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel8.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 180, 32));

        jLabel40.setText("Total  Rp");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, -1, -1));

        total.setText("0");
        total.setEnabled(false);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel8.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 260, -1));

        javax.swing.GroupLayout pn_add1Layout = new javax.swing.GroupLayout(pn_add1);
        pn_add1.setLayout(pn_add1Layout);
        pn_add1Layout.setHorizontalGroup(
            pn_add1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_add1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_add1Layout.setVerticalGroup(
            pn_add1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_add1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelMain.add(pn_add1, "card2");

        add(PanelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void masterdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterdataMouseClicked
        
    }//GEN-LAST:event_masterdataMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        PanelMain.removeAll();
        PanelMain.add(jPanel8);
        PanelMain.repaint();
        PanelMain.revalidate();            
    }//GEN-LAST:event_btntambahActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int pilih = tblhasil.getSelectedRow();
        if (pilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus", "Pemberitahuan", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirmDialog = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirmDialog == JOptionPane.YES_OPTION) {
                String noFakturToDelete = tblhasil.getValueAt(pilih, 0).toString();
                b.Delete(noFakturToDelete);
                loadData();
            }
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        PanelMain.removeAll();
        PanelMain.add(pn_main);
        PanelMain.repaint();
        PanelMain.revalidate();
        loadData();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        
        if ("".equals(noNota.getText())) {
            JOptionPane.showMessageDialog(null, "Tak ada nomer nota yang di pilihi");
        } else {
            Boolean check = b.mencariNoNota(noNota.getText());
            if (check == true) {
                JOptionPane.showMessageDialog(null, "Nomer nota suda ada!");
            } else {
                noNota.setEnabled(false);
                kodePetugas.setEnabled(true);
                kodeDistributor.setEnabled(true);
                kodeBarang.setEnabled(true);
                jumlah.setEnabled(true);
                hitung.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void kodePetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodePetugasActionPerformed
        // TODO add your handling code here
        if (kodePetugas.getSelectedIndex() == 0) {
            namaPetugas.setText("");
        } else {
            for (String[] v : p.Show(kodePetugas.getSelectedItem().toString())) {
                namaPetugas.setText(v[1]);
            }
        }
    }//GEN-LAST:event_kodePetugasActionPerformed

    private void kodeDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeDistributorActionPerformed
        // TODO add your handling code here:
        if (kodeDistributor.getSelectedIndex() == 0) {
            namaDistributor.setText("");
            kota.setText("");
        } else {
            for (String[] v : d.Show(kodeDistributor.getSelectedItem().toString())) {
                namaDistributor.setText(v[1]);
                kota.setText(v[3]);
            }
        }
    }//GEN-LAST:event_kodeDistributorActionPerformed

    private void kodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeBarangActionPerformed
        // TODO add your handling code here:
        if (kodeBarang.getSelectedIndex() == 0) {
            namaBarang.setText("");
            hargaJual.setText("");
            stok.setText("");
        } else {
            for (String[] v : bc.Show(kodeBarang.getSelectedItem().toString())) {
                namaBarang.setText(v[1]);
                hargaJual.setText(v[4]);
                stok.setText(v[5]);
            }
        }
    }//GEN-LAST:event_kodeBarangActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        if ("".equals(stok.getText()) || "".equals(jumlah.getText()) || "".equals(hargaJual.getText())) {
            JOptionPane.showMessageDialog(null, "Data ada yang kosong");
        } else {
            if (Integer.parseInt(jumlah.getText()) > Integer.parseInt(stok.getText())) {
                JOptionPane.showMessageDialog(null, "Stok tidak cukup!");
            } else {
                int jumlahBeli = Integer.parseInt(jumlah.getText()) * Integer.parseInt(hargaJual.getText());
                subTotal.setText(Integer.toString(jumlahBeli));
                addItem.setEnabled(true);
            }
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
        if (kodePetugas.getSelectedIndex() == 0
    || kodeDistributor.getSelectedIndex() == 0
    || kodeBarang.getSelectedIndex() == 0) {
    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
} else {
    // Pengecekan apakah subTotal tidak kosong dan dapat diubah menjadi bilangan bulat
    if (!subTotal.getText().isEmpty()) {
        try {
             
            int subTotalValue = Integer.parseInt(subTotal.getText());
            
            // Perbarui nilai total sebelum menambahkan data ke detail
            int totalNilai = Integer.parseInt(total.getText()) + subTotalValue;
            total.setText(Integer.toString(totalNilai));

            // Tambahkan data ke detail setelah memastikan total sudah diperbarui
            String[] data = {kodeBarang.getSelectedItem().toString(), namaBarang.getText(), jumlah.getText(), subTotal.getText(), total.getText()};
            detail.add(data);
            loadDetail();
            save.setEnabled(true);
            

        } catch (NumberFormatException e) {
            // Tangani jika terjadi NumberFormatException, misalnya dengan memberikan nilai default atau pesan kesalahan
           
            JOptionPane.showMessageDialog(null, "Subtotal bukan bilangan bulat yang valid");
        }
    }
    
    subTotal.setText("0");
    jumlah.setText("");


}




    }//GEN-LAST:event_addItemActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if (dataTable.getRowCount() == 0
            || kodePetugas.getSelectedIndex() == 0
            || kodeDistributor.getSelectedIndex() == 0
            || kodeBarang.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "data tidak boleh ada yang kosong");
        } else {
            b.Store(detail, noNota.getText(), tanggal.getText(), kodePetugas.getSelectedItem().toString(), kodeDistributor.getSelectedItem().toString(), total.getText());
            noNota.setEnabled(true);
            noNota.setText("");
            loadData();
            clearData();
            PanelMain.removeAll();
            PanelMain.add(pn_main);
            PanelMain.repaint();
            PanelMain.revalidate();

        }
    }//GEN-LAST:event_saveActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_totalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMain;
    private javax.swing.JButton addItem;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btntambah;
    private javax.swing.JTable dataTable;
    private javax.swing.ButtonGroup gbt_jenkel;
    private javax.swing.JTextField hargaJual;
    private javax.swing.JButton hitung;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JComboBox<String> kodeBarang;
    private javax.swing.JComboBox<String> kodeDistributor;
    private javax.swing.JComboBox<String> kodePetugas;
    private javax.swing.JTextField kota;
    private javax.swing.JLabel masterdata;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField namaDistributor;
    private javax.swing.JTextField namaPetugas;
    private javax.swing.JTextField noNota;
    private javax.swing.JPanel pn_add1;
    private javax.swing.JPanel pn_main;
    private javax.swing.JButton save;
    private javax.swing.JTextField stok;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTable tblhasil;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

    private void showpanel() {
        PanelMain.removeAll();
        PanelMain.add(new MenuBrgMasuk());
        PanelMain.repaint();
        PanelMain.revalidate();
    }

        

    private void loadData() {
        view.getDataVector().removeAllElements();
        view.fireTableDataChanged();

        if (tblhasil.getColumnCount() == 0) {
            tblhasil.setModel(view);
            view.addColumn("Nomer Nota");
            view.addColumn("Nama Barang");
            view.addColumn("Tanggal");
            view.addColumn("Nama Distributor");
            view.addColumn("Nama Petugas");
            view.addColumn("Total");
        }

        for (String[] v : b.Index()) {
            view.addRow(new Object[]{
                v[0],
                v[1],
                v[2],
                v[3],
                v[4],
                v[5]});
        }

        tanggal.setText(b.Tanggal());
        kodePetugas.setEnabled(false);
        namaPetugas.setEnabled(false);
        kota.setEnabled(false);
        kodeDistributor.setEnabled(false);
        namaDistributor.setEnabled(false);
        kodeBarang.setEnabled(false);
        jumlah.setEnabled(false);
        hitung.setEnabled(false);
        addItem.setEnabled(false);
        save.setEnabled(false);
        loadCombo();
    
    }

    private void loadDetail() {
       view2.getDataVector().removeAllElements();
        view2.fireTableDataChanged();

        if (dataTable.getColumnCount() == 0) {
            dataTable.setModel(view2);
            view2.addColumn("Kode Barang");
            view2.addColumn("Nama Barang");
            view2.addColumn("Jumlah");
            view2.addColumn("Total");
        }

        for (String[] v : detail) {
            view2.addRow(new Object[]{
                v[0],
                v[1],
                v[2],
                v[3],});
        }

        dataTable.setEnabled(false);
    }

    private void loadCombo() {
        for (String[] v : p.Index()) {
            kodePetugas.addItem(v[0]);
        }
        for (String[] v : d.Index()) {
            kodeDistributor.addItem(v[0]);
        }
        for (String[] v : bc.Index()) {
            kodeBarang.addItem(v[0]);
        }
    }

    private void clearData() {
        noNota.setText("");
        kodeDistributor.setSelectedIndex(0);
        kodePetugas.setSelectedIndex(0);
        kodeBarang.setSelectedIndex(0);
        jumlah.setText("");
        subTotal.setText("");
        total.setText("");
    } 

    
  private void TampilId() throws SQLException {
        Date sk = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
        String time = format1.format(sk);

        String sql = "SELECT MAX(CAST(SUBSTRING(NoNota, 7) AS UNSIGNED)) AS max_kode FROM tblbrgmasuk";
        koneksi.getKoneksi();

        try (Statement cn = conn.createStatement(); ResultSet rs = cn.executeQuery(sql)) {
            if (rs.next()) {
                int maxKode = rs.getInt("max_kode");
                int newKode = maxKode + 1;
                noNota.setText(time + String.format("%03d", newKode)); 
            } else {
                int kode = 1;
                noNota.setText(time + String.format("%03d", kode)); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}


