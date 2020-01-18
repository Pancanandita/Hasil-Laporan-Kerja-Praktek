/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaansmp;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public final class f_DataPengembalian extends javax.swing.JInternalFrame {

    DefaultTableModel tabmode;
    DefaultTableModel tabmodel;
//     DefaultTableModel tabmode2;
    Perpustakaansmp conn = new Perpustakaansmp();
    int keterlambatan;
    int denda;
    int subtotaldenda;
    
    public f_DataPengembalian() {
        initComponents();
        Tbldetailpengembaliansemua();
        Tbersih();
        Pilihidpeminjaman();
        tglsekarang();
        
        
        tabmodel =new DefaultTableModel();
        Tbldetailpeminjaman.setModel(tabmodel);
        tabmodel.addColumn("KLASIFIKASI BUKU");
        tabmodel.addColumn("NAMA BUKU");
        tabmodel.addColumn("KATEGORI");
        tabmodel.addColumn("PENULIS");
        tabmodel.addColumn("JUMLAH PINJAM");
        
//        Tbldetailpeminjaman.getColumnModel().getColumn(4).setMinWidth(0);
//        Tbldetailpeminjaman.getColumnModel().getColumn(4).setMaxWidth(0);
//        Tbldetailpeminjaman.getColumnModel().getColumn(4).setWidth(0);
//        
//        tabmode2 =new DefaultTableModel();
//        Tbldetailpengembalian.setModel(tabmode2);
//        tabmode2.addColumn("KODE BUKU");
//        tabmode2.addColumn("NAMA BUKU");
//        tabmode2.addColumn("KATEGORI");
//        tabmode2.addColumn("PENULIS");
//        tabmode2.addColumn("JUMLAH PINJAM");
        
        

        
    }

//    public void tglditext(){
//        Date tgl = new Date();
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Ttglkembali.setText(format.format(tgl));
//    }
    
    public void tglsekarang(){
        Date tgl = new Date();
        Ttglsekarang.setDate(tgl);
    }
    
    public void Tbersih(){
        Tidpeminjaman.setSelectedItem("");
        Tidpengembalian.setText("");
        Ttglkembali.setDate(null);
        Tterlambat.setText("");
        Tdenda.setText("");
        
        Ttglpinjam.setText("");
        Tidanggota.setText("");
        Tnamaanggota.setText("");
        Ttotpinjam.setText("");
        Tstatus.setSelectedItem("");
        TTglkembali.setText("");
        
        Tkdbuku.setText("");
        Tnamabuku.setText("");
        Tkategori.setText("");
        Tpenulis.setText("");
        Tjumlahbuku.setText("");
        
        Tsubtotaldenda.setText("");
        Tidpengembalian.requestFocus();
    }
    
    public int Tsimpan(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //Tbldetailpengembalian.setModel(new DefaultTableModel  (null,new String []{"KODE BUKU","NAMA BUKU","KATEGORI","PENULIS","JUMLAH PINJAM"}));
        //format.format(Ttglkembali.getDate());
        //keterlambatan = Integer.parseInt(Tterlambat.getText());
        //denda = Integer.parseInt(Tdenda.getText());
       // subtotaldenda = Integer.parseInt(Tsubtotaldenda.getText());
        simpandetail_pengembalian();
        String sql="insert into tbl_pengembalian(id_pengembalian,tgl_pengembalian,id_peminjaman,keterlambatan,denda,status,subtotal)"+
                "values"+
                "('"+Tidpengembalian.getText()+"', "+
                "'"+format.format(Ttglkembali.getDate())+"', "+
                "'"+Tidpeminjaman.getSelectedItem().toString()+"', "+
                "'"+Tterlambat.getText()+"', "+
                "'"+Tdenda.getText()+"', "+
                "'"+Tstatus.getSelectedItem().toString()+"', "+
                "'"+Tsubtotaldenda.getText()+"'"+")";         
                conn.simpanData(sql);
                JOptionPane.showMessageDialog(rootPane, "Data berhasil di simpan..!!");
        return 0;
        
    }
    
    public int Thapus (){
        int tny = JOptionPane.showConfirmDialog(null, "Yakin Ingin Hapus Data ?","tanya",JOptionPane.YES_NO_CANCEL_OPTION);
        if (tny==0) {
            try{
              String sql="delete from tbl_pengembalian where id_pengembalian='"+Tidpengembalian.getText()+"' ";  
              conn.simpanData(sql);
              Tbldetailpengembaliansemua();
              JOptionPane.showMessageDialog(null, "Data Sudah Di Hapus");
            }catch (Exception e){     
            }
        }
         return 0;
     } 
      
    public void Pilihidpeminjaman(){
    Tidpeminjaman.removeAllItems();
    Tidpeminjaman.addItem("Select");
    try {
        ResultSet res = conn.ambilData("select * from tbl_peminjaman");      
        while(res.next()){
            String AString = res.getString("id_peminjaman");
            Tidpeminjaman.addItem(AString);
        } 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data id_peminjaman dari tbl_peminjaman");
    }
    }
    
    
   
    
    public void Tbldetailpengembaliansemua(){
         tabmode = new DefaultTableModel();
         tabmode.addColumn("NO");
         tabmode.addColumn("ID PENGEMBALIAN");
         tabmode.addColumn("TANGGAL PENGEMBALIAN");
         tabmode.addColumn("ID PEMINJAMAN");
         tabmode.addColumn("KETERLAMBATAN");
         tabmode.addColumn("DENDA");
         tabmode.addColumn("STATUS");
         tabmode.addColumn("SUB TOTAL DENDA");
         Tbldetailpengembaliansemua.setModel(tabmode);
         try {
             int i=1;
               ResultSet res = conn.ambilData("select *from tbl_pengembalian");
               while (res.next()){
                   tabmode.addRow(new Object[]{""+i++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
               }
//         Tbldetailpengembaliansemua.setModel(tabmode);
//         Tbldetailpengembaliansemua.enable(false);
//         Tbldetailpengembaliansemua.requestFocus();
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex);
         }         
     }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Tidpengembalian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Ttglkembali = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        Tterlambat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Tdenda = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Tsubtotaldenda = new javax.swing.JTextField();
        Ttotalsub = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Tidpeminjaman = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Ttglpinjam = new javax.swing.JTextField();
        Tidanggota = new javax.swing.JTextField();
        Tnamaanggota = new javax.swing.JTextField();
        Ttotpinjam = new javax.swing.JTextField();
        TTglkembali = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Tsimpan = new javax.swing.JButton();
        Tbersih = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Tstatus = new javax.swing.JComboBox<>();
        Ttglsekarang = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Tkdbuku = new javax.swing.JTextField();
        Tnamabuku = new javax.swing.JTextField();
        Tkategori = new javax.swing.JTextField();
        Tpenulis = new javax.swing.JTextField();
        Tjumlahbuku = new javax.swing.JTextField();
        Ttambah = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbldetailpeminjaman = new javax.swing.JTable();
        Ttblpengembalian = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbldetailpengembaliansemua = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbldetailpengembalian = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Pengembalian");

        jPanel1.setBackground(new java.awt.Color(81, 101, 131));

        jPanel2.setBackground(new java.awt.Color(123, 132, 150));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KELOLA DATA PENGEMBALIAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Medium 404.png"))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("PENGEMBALIAN"));
        jPanel4.setToolTipText("PENGEMBALIAN");
        jPanel4.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("ID PENGEMBALIAN");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("TANGGAL KEMBALI ");

        Ttglkembali.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TtglkembaliAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Tidpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(Ttglkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tidpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Ttglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("KETERLAMBATAN"));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("TERLAMBAT");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("DENDA");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("SUB TOTAL DENDA");

        Tsubtotaldenda.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Tsubtotaldenda.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        Ttotalsub.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Ttotalsub.setText("SUB TOTAL");
        Ttotalsub.setAutoscrolls(true);
        Ttotalsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtotalsubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tdenda)
                    .addComponent(Tterlambat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Ttotalsub)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tsubtotaldenda))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Tterlambat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Tdenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tsubtotaldenda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ttotalsub))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("PEMINJAMAN"));

        Tidpeminjaman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tidpeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidpeminjamanActionPerformed(evt);
            }
        });
        Tidpeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TidpeminjamanKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("ID PEMINJAMAN");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("TANGGAL PINJAM");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("ID ANGGOTA");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("NAMA ANGGOTA");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("TOTAL PINJAM");

        Ttglpinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtglpinjamActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setText("TANGGAL KEMBALI");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ttotpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tidanggota)
                            .addComponent(Tnamaanggota, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(Ttglpinjam, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tidpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TTglkembali))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tidpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Ttglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Tidanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Tnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Ttotpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TTglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Tsimpan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Tsimpan.setText("SIMPAN");
        Tsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TsimpanActionPerformed(evt);
            }
        });

        Tbersih.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Tbersih.setText("BERSIH");
        Tbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TbersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(Tbersih))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tsimpan)
                    .addComponent(Tbersih))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel15.setText("STATUS");

        Tstatus.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        Tstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BUKU KEMBALI", "BUKU HILANG" }));

        Ttglsekarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TtglsekarangKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel17.setText("KLASIFIKASI BUKU");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel18.setText("NAMA BUKU");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel19.setText("KATEGORI");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel20.setText("PENULIS");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel21.setText("JUMLAH PINJAM");

        Ttambah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Ttambah.setText("+");
        Ttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtambahActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel22.setText("Catatan:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel23.setText("Id Pengembalian dimulai dari IP1");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel24.setText("Denda Buku Pelajaran 3 hari Rp.1000");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel25.setText("Buku hilang denda seharga buku");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jLabel22)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel23)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel24)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Tjumlahbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(Tstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Ttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Tpenulis)
                                        .addGap(10, 10, 10)))
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tkdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tnamabuku, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Ttglsekarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(56, 56, 56))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addComponent(jLabel15))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Ttglsekarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(Tkdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(Tnamabuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(Tkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(Tpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel21)
                                            .addComponent(Tjumlahbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(Tstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Ttambah)))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Peminjaman"));

        Tbldetailpeminjaman.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Tbldetailpeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KLASIFIKASI BUKU", "NAMA BUKU", "KATEGORI", "PENULIS", "JUMLAH PINJAM"
            }
        ));
        Tbldetailpeminjaman.setColumnSelectionAllowed(true);
        Tbldetailpeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbldetailpeminjamanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbldetailpeminjaman);
        Tbldetailpeminjaman.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        Ttblpengembalian.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Pengembalian Semua"));

        Tbldetailpengembaliansemua.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Tbldetailpengembaliansemua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tbldetailpengembaliansemua);

        javax.swing.GroupLayout TtblpengembalianLayout = new javax.swing.GroupLayout(Ttblpengembalian);
        Ttblpengembalian.setLayout(TtblpengembalianLayout);
        TtblpengembalianLayout.setHorizontalGroup(
            TtblpengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TtblpengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        TtblpengembalianLayout.setVerticalGroup(
            TtblpengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TtblpengembalianLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Pengembalian"));

        Tbldetailpengembalian.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Tbldetailpengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KLASIFIKASI BUKU", "NAMA BUKU", "KATEGORI", "PENULIS", "JUMLAH PINJAM"
            }
        ));
        Tbldetailpengembalian.setColumnSelectionAllowed(true);
        Tbldetailpengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbldetailpengembalianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tbldetailpengembalian);
        Tbldetailpengembalian.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Ttblpengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ttblpengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 1274, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void TtglpinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtglpinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtglpinjamActionPerformed

    private void TbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TbersihActionPerformed
        // TODO add your handling code here:
        Tbersih();
        Tbldetailpengembaliansemua(); 
        Tbldetailpengembaliansemua.setEnabled(true);
    }//GEN-LAST:event_TbersihActionPerformed

    private void TidpeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidpeminjamanActionPerformed
        // TODO add your handling code here:
        try {
            ResultSet res = conn.ambilData("select * from tbl_peminjaman where id_peminjaman='"+Tidpeminjaman.getSelectedItem().toString()+"'");
            while (res.next()){
                Ttglpinjam.setText(res.getString("tgl_pinjam")); //sesuai dengan database dalam tbl_buku.
                Tidanggota.setText(res.getString("id_anggota"));
                Tnamaanggota.setText(res.getString("nama_anggota"));
                Ttotpinjam.setText(res.getString("total_pinjam"));
                TTglkembali.setText(res.getString("tanggal_kembali"));
                loadData1();
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_TidpeminjamanActionPerformed

    private void TtglsekarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TtglsekarangKeyPressed
        // TODO add your handling code here:
        if (Ttglsekarang.getDate()!=null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy=mm-dd");
            format.format(Ttglsekarang.getDate());
        }
    }//GEN-LAST:event_TtglsekarangKeyPressed

    private void TsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TsimpanActionPerformed
        // TODO add your handling code here:
        Tsimpan();
        Tbersih();
        Tbldetailpengembaliansemua(); 
        Tbldetailpengembaliansemua.setEnabled(true);
        tabmodel.getDataVector().removeAllElements();
        tabmodel.fireTableDataChanged();
        Tbldetailpengembalian.setModel(new DefaultTableModel  (null,new String []{"KLASIFIKASI BUKU","NAMA BUKU","KATEGORI","PENULIS","JUMLAH PINJAM"}));
//        Bersih();
        
       // loadData1();
    }//GEN-LAST:event_TsimpanActionPerformed

    private void TbldetailpeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbldetailpeminjamanMouseClicked
        Cari_KodeBuku1();
        ShowDataPinjam();
    }//GEN-LAST:event_TbldetailpeminjamanMouseClicked

    private void TidpeminjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TidpeminjamanKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TidpeminjamanKeyPressed

    private void TbldetailpengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbldetailpengembalianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbldetailpengembalianMouseClicked

    private void TtotalsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtotalsubActionPerformed
        // TODO add your handling code here:
        subtotal();
    }//GEN-LAST:event_TtotalsubActionPerformed

    private void TtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtambahActionPerformed
        
        Tambahbuku();
        loadData1();
        
    }//GEN-LAST:event_TtambahActionPerformed

    private void TtglkembaliAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TtglkembaliAncestorAdded
        // TODO add your handling code here:
        if (Ttglkembali.getDate()!=null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy=mm-dd");
            format.format(Ttglkembali.getDate());
        }
    }//GEN-LAST:event_TtglkembaliAncestorAdded

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Thapus();
        Tbersih();
        Tbldetailpengembaliansemua(); 
        Tbldetailpengembaliansemua.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TTglkembali;
    private javax.swing.JButton Tbersih;
    private javax.swing.JTable Tbldetailpeminjaman;
    private javax.swing.JTable Tbldetailpengembalian;
    private javax.swing.JTable Tbldetailpengembaliansemua;
    private javax.swing.JTextField Tdenda;
    private javax.swing.JTextField Tidanggota;
    private javax.swing.JComboBox<String> Tidpeminjaman;
    private javax.swing.JTextField Tidpengembalian;
    private javax.swing.JTextField Tjumlahbuku;
    private javax.swing.JTextField Tkategori;
    private javax.swing.JTextField Tkdbuku;
    private javax.swing.JTextField Tnamaanggota;
    private javax.swing.JTextField Tnamabuku;
    private javax.swing.JTextField Tpenulis;
    private javax.swing.JButton Tsimpan;
    private javax.swing.JComboBox<String> Tstatus;
    private javax.swing.JTextField Tsubtotaldenda;
    private javax.swing.JButton Ttambah;
    private javax.swing.JPanel Ttblpengembalian;
    private javax.swing.JTextField Tterlambat;
    private com.toedter.calendar.JDateChooser Ttglkembali;
    private javax.swing.JTextField Ttglpinjam;
    private com.toedter.calendar.JDateChooser Ttglsekarang;
    private javax.swing.JButton Ttotalsub;
    private javax.swing.JTextField Ttotpinjam;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    
    public void Tambahbuku() {
    //int jmlhpinjam;
    try {
       // tabmode = new DefaultTableModel();
       DefaultTableModel tabmodea = (DefaultTableModel)Tbldetailpengembalian.getModel();
       String[]data = new String[6];
       data[0]= String.valueOf(Tkdbuku.getText());
       data[1]= Tnamabuku.getText();
       data[2]= Tkategori.getText();
       data[3]= Tpenulis.getText();
       data[4]= Tjumlahbuku.getText();
       data[5]= Tstatus.getSelectedItem().toString();
       tabmodea.addRow(data);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Eror menampilkan data. . . .");
    }

    }
    
    
    
    public void subtotal(){
       int jumlah = Integer.parseInt(Tterlambat.getText()) * Integer.parseInt(Tdenda.getText());
       Tsubtotaldenda.setText(""+jumlah);
    }
    
    public final void loadData1(){
   tabmodel.getDataVector().removeAllElements();
   tabmodel.fireTableDataChanged();
   try{  
       try ( 
               ResultSet res = conn.ambilData("select * from detail_pinjam where id_peminjaman= '"+Tidpeminjaman.getSelectedItem().toString()+"'")) {
           while (res.next()) {
               Object[]o=new Object[5];
               o[0]=res.getString("kode_buku");//t_brg
               o[1]=res.getString("nama_buku");//t_brg
               o[2]=res.getString("kategori");//t_detjual
               o[3]=res.getString("penulis");//t_brg
               o[4]=res.getString("jumlah_pinjam");//t_brg
               tabmodel.addRow(o);
               //conn.simpanData(sql);
           }
           //res.close();
       }
   }catch(Exception e){ 
       JOptionPane.showMessageDialog(null, "Gagal menampilkan Data pinjam buku..!!");
     System.out.println("Terjadi Kesalahan");  
   }
    }
    
    
     public void Cari_KodeBuku1(){
   int i=Tbldetailpeminjaman.getSelectedRow();  
   if(i==-1)  
   { return; }  
   String ID=(String)tabmodel.getValueAt(i,0); 
   Tkdbuku.setText(ID);
   }
      
    public void ShowDataPinjam(){
   try {
       try (
               ResultSet res = conn.ambilData("Select * from detail_pinjam, tbl_buku "
                + "WHERE detail_pinjam.kode_buku = tbl_buku.kode_buku "
                + "AND detail_pinjam.kode_buku='"+Tkdbuku.getText()+"'")) {
           while(res.next()){
               this.Tkdbuku.setText(res.getString("kode_buku"));
               Tkdbuku.setEnabled(false);
               this.Tnamabuku.setText(res.getString("nama_buku")); //t_detailjual
               Tnamabuku.setEnabled(false);
               this.Tkategori.setText(res.getString("kategori")); //t_detailjual
               Tkategori.setEnabled(false);
               this.Tpenulis.setText(res.getString("penulis"));
               Tpenulis.setEnabled(false);
               this.Tjumlahbuku.setText(res.getString("jumlah_pinjam")); //t_detailjual
               Tjumlahbuku.setEnabled(false);
           }
//           Tkdbuku.enable(false);
//           Tnamabuku.enable(false);
//           Tkategori.enable(false);
//           Tpenulis.enable(false);
//           Tjumlahbuku.enable(false);
        }
        }
               catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void simpandetail_pengembalian(){
        int jumlah_baris = Tbldetailpengembalian.getRowCount();
    if (jumlah_baris == 0) {
        JOptionPane.showMessageDialog(rootPane, "Table Masih Kosong..!!");
    }else   {
        try{
            int i=0;
            while (i<jumlah_baris){
                String sql="insert into detail_pengembalian(id_pengembalian,kode_buku,nama_buku, kategori, penulis, jumlah_pinjam,status)"+
                "values"+
                "('"+Tidpengembalian.getText()+"', "+
                "'"+Tbldetailpengembalian.getValueAt(i, 0)+"', "+  
                "'"+Tbldetailpengembalian.getValueAt(i, 1)+"', "+
                "'"+Tbldetailpengembalian.getValueAt(i, 2)+"', "+
                "'"+Tbldetailpengembalian.getValueAt(i, 3)+"', "+ 
                "'"+Tjumlahbuku.getText()+"', "+
                "'"+Tstatus.getSelectedItem().toString()+"'"+")";
                i++;
            conn.simpanData(sql);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal menyimpan..!!");
        }
    }
}
    
     public final void loadData3(){
   tabmodel.getDataVector().removeAllElements();
   tabmodel.fireTableDataChanged();
  
    }
    
     //     public void Cari_KodeBuku2(){
//   int i=Tbldetailpengembalian.getSelectedRow();  
//   if(i==-1)  
//   { return; }  
//   String ID=(String)tabmode2.getValueAt(i,0); 
//   Tkdbuku.setText(ID);
//   }
//    
//     public final void loadData2(){
//   tabmode2.getDataVector().removeAllElements();
//   tabmode2.fireTableDataChanged();
//   try{  
//       try ( 
//               ResultSet res = conn.ambilData("select * from detail_pinjam where id_peminjaman= '"+Tidpeminjaman.getSelectedItem().toString()+"'")) {
//           while (res.next()) {
//               Object[]o=new Object[5];
//               o[0]=res.getString("kode_buku");//t_brg
//               o[1]=res.getString("nama_buku");//t_brg
//               o[2]=res.getString("kategori");//t_detjual
//               o[3]=res.getString("penulis");//t_brg
//               o[4]=res.getString("jumlah_pinjam");//t_brg
//               tabmode2.addRow(o);
//               //conn.simpanData(sql);
//           }
//           res.close();
//       }
//   }catch(Exception e){ 
//       JOptionPane.showMessageDialog(null, "Gagal menampilkan Data pinjam buku..!!");
//     System.out.println("Terjadi Kesalahan");  
//   }
//    }
    
    
     
     
//  public void TambahDetailPeminjaman(){
//
//   String notrans =this.Tidpeminjaman.getSelectedItem().toString();  
//   String kodebuku =Ttglpinjam.getText();
//   String jdbuku=this.Tidanggota.getText();  
//   String pngrng=this.Tnamaanggota.getText();
//   String qty =this.Ttotpinjam.getText();
//
//   try{  
//    // Connection c=POS05.getkoneksi();  
//     //String sql="Insert into detail_pinjam(id_peminjaman,kode_buku,nama_buku, kategori, penulis, jumlah_pinjam) values "
//            // + "(?,?,?,?,?,?)";  
////     PreparedStatement p=(PreparedStatement)conn.prepareStatement(sql);
//       try (ResultSet res = conn.ambilData("Insert into detail_pinjam (id_peminjaman,kode_buku,nama_buku, kategori, penulis, jumlah_pinjam) values + \"(?,?,?,?,?,?)\" ")) {
//           //     PreparedStatement p=(PreparedStatement)conn.prepareStatement(sql);
//           res.getString("1,notrans");
//           res.getString("2,kodebuku");
//           res.getString("3,jdbuku");
//           res.getString("4,pngrng");
//           res.getString("5,qty");
////           res.getString(6,DateTime);
//          // res.executeUpdate();
//           res.close();
//           conn.simpanData(sql);
//       }
//       
//     
//    
//   }catch(Exception e){ 
//   System.out.println(e);  
//   }finally{  
//   //loadData();
//       //JOptionPane.showMessageDialog(this,"Data Telah Tersimpan");  
//  }
// }   
     
     
     
}
