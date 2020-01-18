/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaansmp;

//import perpustakaansmp.splash;
//import perpustakaansmp.form_login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Perpustakaansmp {
    
    public static Connection koneksi;
      public Statement st;
      private static com.mysql.jdbc.Connection con;
      
      public static Connection getConnection(){
          if(koneksi==null){
              try {
                  String server="jdbc:mysql://localhost:3306/perpustakaan";
                  String user = "root";
                  String password = "";
                  Class.forName("com.mysql.jdbc.Driver");
                  koneksi = DriverManager.getConnection(server,user,password);
                  JOptionPane.showMessageDialog(null,"Koneksi Database Perpustakan Berhasil");
              } catch (ClassNotFoundException | SQLException x) {
                  JOptionPane.showMessageDialog(null,"Koneksi Gagal, Pesan error \n"+ x);
              }
          }
        return koneksi;
      }
      
      public void koneksi(){
          try {
              getConnection();
              st=koneksi.createStatement();
          } catch (SQLException x) {
              JOptionPane.showMessageDialog(null,"Koneksi ambil gagal, pesan error \n"+ x);
          }
      }
      
//     public void tutupKoneksi(ResultSet rs){
//          try {
//              if(rs!=null){
//                  rs.close();
//              }
//              st.close();
//              koneksi.close();
//          } catch(SQLException x){
//              JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal, Pesan error "+x);
//          }
//      }
      

      public ResultSet ambilData(String sql){
          ResultSet rs = null; 
          try {
            koneksi();
            rs=st.executeQuery(sql);
//            JOptionPane.showMessageDialog(null,"ambilData berhasil");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null,"Ambil Data Gagal, Proses error : \n"+x );
        }
        return rs;
      }
    
    public void simpanData(String sql){
        try {
            koneksi();
            st.executeUpdate(sql);
//            JOptionPane.showMessageDialog(null,"simpanData berhasil");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null,"Simpan Data gagal, Proses error : \n"+x );
            System.out.print(x);
        }
      }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        splash Sp = new splash();
     Sp.setVisible(true);
     form_login fl = new form_login(); // awal mulai masuk form_login
        try {
            for (int i=0; i <= 100; i++) 
            {
                Thread.sleep(40);
                Sp.time.setText(Integer.toString(i)+"%");
                Sp.loadingbar.setValue(i);
                if(i==100)
                {
                   Sp.setVisible(false);
                   fl.setVisible(true); // jika benar maka akan masuk ke form_login
                }
            }
        } catch (Exception e) {
        }
        
    }
    
}
