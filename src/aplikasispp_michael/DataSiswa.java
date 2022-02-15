/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasispp_michael;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfon
 */
public class DataSiswa extends javax.swing.JFrame {

    /**
     * Creates new form DataSiswa
     */
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public DataSiswa() {
        initComponents();
        try{
            conn = Koneksi.fungsiKoneksi();
            tampilkan_datasiswa();
            tampilkan_kelas();
            tampilkan_spp();            
            System.out.println("Terbuhung dengan Fungsi Koneksi");
        }catch(SQLException ex){
            System.out.println("Gagal Terhubung dengan fungsi Koneksi");
        }
    }

    
    private void tampilkan_datasiswa(){
        String query = "SELECT * FROM siswa";
        
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            DefaultTableModel tableSiswa = new DefaultTableModel();
            
            tableSiswa.addColumn("NISN");
            tableSiswa.addColumn("KELAS");
            tableSiswa.addColumn("Nama Pesdik");
            tableSiswa.addColumn("Alamat");
            tableSiswa.addColumn("Telepon");
            tableSiswa.addColumn("HP");
            tableSiswa.addColumn("ID SPP");
            
            
            while(rs.next()){
                tableSiswa.addRow(new Object[]
                {
                    rs.getString(1),rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getString(5),rs.getString(6),
                    rs.getString(7)
                });
            }
            
            
            jTable1.setModel(tableSiswa);
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void tampilkan_kelas(){
        String query = "SELECT * FROM kelas";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                combobox_kelas.addItem(rs.getString("id_kelas"));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal Menampilakn Combobox Kelas");
//            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    private void tampilkan_spp(){
        String query = "SELECT * FROM spp";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                combo_box_id_spp.addItem(rs.getString("id_spp"));
//                combo_box_id_spp.addItem(rs.getString("tahun"));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal Menampilakn Combobox Spp");
//            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        txt_nisn = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_nama_pesdik = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_telepon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        combobox_kelas = new javax.swing.JComboBox<>();
        combo_box_id_spp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Data Peserta Didik");

        jLabel2.setText("NISN");

        txt_nisn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nisnActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel3.setText("Kelas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnUbah.setText("Edit");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");

        jLabel4.setText("Nama Pesdik");

        txt_nama_pesdik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_pesdikActionPerformed(evt);
            }
        });

        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });

        jLabel6.setText("Telepon");

        txt_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hpActionPerformed(evt);
            }
        });

        jLabel7.setText("HP");

        jLabel8.setText("ID SPP");

        jLabel9.setText("Cari Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nisn, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                    .addComponent(txt_nama_pesdik)
                                    .addComponent(txt_alamat)
                                    .addComponent(txt_telepon)
                                    .addComponent(txt_hp)
                                    .addComponent(combobox_kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_box_id_spp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnUbah)
                    .addComponent(combobox_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_nama_pesdik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(combo_box_id_spp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nisnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nisnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nisnActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
       
        try {
            int row = jTable1.getSelectedRow();
            String diklik = (jTable1.getModel().getValueAt(row, 0).toString());
            String ubah = "UPDATE siswa set id_kelas = ?, nama_pesdik = ? , alamat = ?, telepon = ?,hp = ?,id_spp = ? WHERE nisn = ?";
            pst = conn.prepareStatement(ubah);
            
            
            String isiKelas = (String)combobox_kelas.getSelectedItem();
            pst.setString(1, isiKelas);
            
            pst.setString(2, txt_nama_pesdik.getText());
            pst.setString(3, txt_alamat.getText());
            pst.setString(4, txt_telepon.getText());
            pst.setString(5, txt_hp.getText());
            
            String isispp =(String)combo_box_id_spp.getSelectedItem();
            pst.setString(6, isispp);
            pst.setString(7, diklik);
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di update");
            tampilkan_datasiswa();
//          kosongkan();
        } catch (SQLException ex) {
            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txt_nama_pesdikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_pesdikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_pesdikActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleponActionPerformed

    private void txt_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hpActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
      
        try {
            int row = jTable1.getSelectedRow();
            String diklik = (jTable1.getModel().getValueAt(row, 0).toString());
            String keklik = "SELECT * FROM siswa where nisn='"+diklik+"'";
            pst = conn.prepareStatement(keklik);
            rs = pst.executeQuery();
            
            if ((rs.next())) {
                String set1 = rs.getString("nisn");
                txt_nisn.setText(set1);
                
                String isikelas = rs.getString("id_kelas");
                combobox_kelas.setSelectedItem(isikelas);
                
                String set2 = rs.getString("nama_pesdik");
                txt_nama_pesdik.setText(set2);
                
                String set3 = rs.getString("alamat");
                txt_alamat.setText(set3);
                
                String set4 = rs.getString("telepon");
                txt_telepon.setText(set4);
                
                String set5 = rs.getString("hp");
                txt_hp.setText(set5);
                
                String isispp = rs.getString("id_spp");
                combo_box_id_spp.setSelectedItem(isispp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> combo_box_id_spp;
    private javax.swing.JComboBox<String> combobox_kelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_hp;
    private javax.swing.JTextField txt_nama_pesdik;
    private javax.swing.JTextField txt_nisn;
    private javax.swing.JTextField txt_telepon;
    // End of variables declaration//GEN-END:variables
}
