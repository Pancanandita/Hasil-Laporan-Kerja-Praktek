/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaansmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
       
       //Perpustakaansmptunasbaru f = new Perpustakaansmptunasbaru();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        DataAnggota = new javax.swing.JMenuItem();
        DataBuku = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        DataPeminjaman = new javax.swing.JMenuItem();
        DataPengembalian = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        fdetailpengembalian = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");
        setIconImages(null);

        Desktop.setBackground(new java.awt.Color(240, 240, 240));
        Desktop.setMaximumSize(new java.awt.Dimension(1080, 720));

        jPanel2.setBackground(new java.awt.Color(81, 101, 131));

        jPanel1.setBackground(new java.awt.Color(123, 132, 150));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("  PERPUSTAKAAN SMP TUNAS BARU CIPARAY");
        jLabel1.setToolTipText("");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo Smp Tunas Baru.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("                           Yayasan Tunas Baru Ciparay, Jalan Raya Laswi Baleendah No.492, Gunungleutik, Ciparay, Bandung, Jawa Barat 40381");
        jLabel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("                                                                                Ciparay, Bandung, West Java (022) 85966103");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Desktop.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 380, Short.MAX_VALUE))
        );

        jMenuBar2.setName("Accessible Name\tPERPUSTAKAAN SMP TUNAS BARU CIPARAY"); // NOI18N

        jMenu3.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jMenuItem9.setText("Exit");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Data");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        DataAnggota.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        DataAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/anggota.png"))); // NOI18N
        DataAnggota.setText("Data Anggota");
        DataAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataAnggotaActionPerformed(evt);
            }
        });
        jMenu4.add(DataAnggota);

        DataBuku.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        DataBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/detail toolbar.png"))); // NOI18N
        DataBuku.setText("Data Buku");
        DataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataBukuActionPerformed(evt);
            }
        });
        jMenu4.add(DataBuku);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Transaksi");

        DataPeminjaman.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        DataPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Medium 0034.png"))); // NOI18N
        DataPeminjaman.setText("Data Peminjaman");
        DataPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPeminjamanActionPerformed(evt);
            }
        });
        jMenu1.add(DataPeminjaman);

        DataPengembalian.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        DataPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/peminjaman.png"))); // NOI18N
        DataPengembalian.setText("Data Pengembalian");
        DataPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPengembalianActionPerformed(evt);
            }
        });
        jMenu1.add(DataPengembalian);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Medium 0034.png"))); // NOI18N
        jMenuItem3.setText("Detail Peminjaman");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        fdetailpengembalian.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        fdetailpengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/peminjaman.png"))); // NOI18N
        fdetailpengembalian.setText("Detail Pengembalian");
        fdetailpengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdetailpengembalianActionPerformed(evt);
            }
        });
        jMenu1.add(fdetailpengembalian);

        jMenuBar2.add(jMenu1);

        jMenu6.setText("Tentang");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit toolbar.png"))); // NOI18N
        jMenuItem11.setText("Tentang Aplikasi");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);
        jMenuBar2.getAccessibleContext().setAccessibleName("PERPUSTAKAAN SMP TUNAS BARU CIPARAY");
        jMenuBar2.getAccessibleContext().setAccessibleDescription("Accessible Name\tPERPUSTAKAAN SMP TUNAS BARU CIPARAY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("PERPUSTAKAAN SMP TUNAS BARU CIPARAY");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Sistem Logout Menu
        form_login log = new form_login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void DataAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataAnggotaActionPerformed
        // TODO add your handling code here:
        // Desktop.removeAll();
        //Desktop.repaint();
        f_DataAnggota fda = new f_DataAnggota();
        Desktop.add(fda);
        fda.setVisible(true);
    }//GEN-LAST:event_DataAnggotaActionPerformed

    private void DataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataBukuActionPerformed
        // TODO add your handling code here:
        //Desktop.removeAll();
        //Desktop.repaint();
        f_DataBuku fdb = new f_DataBuku();
        Desktop.add(fdb);
        fdb.setVisible(true);
    }//GEN-LAST:event_DataBukuActionPerformed

    private void DataPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataPeminjamanActionPerformed
        // TODO add your handling code here:
        // Desktop.removeAll();
        //Desktop.repaint();
        f_DataPeminjaman fdp = new f_DataPeminjaman();
        Desktop.add(fdp);
        fdp.setVisible(true);
    }//GEN-LAST:event_DataPeminjamanActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
//        Desktop.removeAll();
//        Desktop.repaint();
        Tentang_Aplikasi ta = new Tentang_Aplikasi();
        Desktop.add(ta);
        ta.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void DataPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataPengembalianActionPerformed
        // TODO add your handling code here:
        f_DataPengembalian fdpb = new f_DataPengembalian();
        Desktop.add(fdpb);
        fdpb.setVisible(true);
    }//GEN-LAST:event_DataPengembalianActionPerformed

    private void fdetailpengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdetailpengembalianActionPerformed
        // TODO add your handling code here:
       // fdetailpengembalian
        f_Detailpengembalianbuku fdpbb = new f_Detailpengembalianbuku();
        Desktop.add(fdpbb);
        fdpbb.setVisible(true);
    }//GEN-LAST:event_fdetailpengembalianActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        f_Detailpeminjamanbuku fdpbbP = new f_Detailpeminjamanbuku();
        Desktop.add(fdpbbP);
        fdpbbP.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DataAnggota;
    private javax.swing.JMenuItem DataBuku;
    private javax.swing.JMenuItem DataPeminjaman;
    private javax.swing.JMenuItem DataPengembalian;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem fdetailpengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables



}