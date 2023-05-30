/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOPelanggan;
import koneksi.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplementPelanggan.DataPengunjungImpelent;
/**
 *
 * @author upima
 */
public class DAOPelanggan implements DataPengunjungImpelent {

    Connection conn = Koneksi.koneksi();
    
    @Override
    public void insert(DataPelanggan p) {
        String query = "INSERT INTO data_pelanggan (nama_pelanggan,jenis_kelamin,alamat,no_telpon,cek_in,cek_out,kamar,harga) value(?,?,?,?,?,?,?,?); ";
           
        java.util.Date cek_in_util = p.getCek_in();
        java.util.Date cek_out_util = p.getCek_out();
        java.sql.Date cek_in_sql = new java.sql.Date(cek_in_util.getTime());
        java.sql.Date cek_out_sql = new java.sql.Date(cek_out_util.getTime());
        try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1, p.getNama());
           ps.setString(2, p.getJenis_kelamin());
           ps.setString(3, p.getAlamat());
           ps.setString(4, p.getNo_telpon());
           ps.setDate(5,cek_in_sql);
           ps.setDate(6, cek_out_sql);
           ps.setString(7, p.getKamar());
           ps.setInt(8, p.getHarga());
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
    }

    @Override
    public void update(DataPelanggan p) {
        String query = "UPDATE data_pelanggan SET nama_pelanggan=?, jenis_kelamin=? , alamat=? , no_telpon = ?, cek_in = ?, cek_out = ?, kamar = ?, harga = ? WHERE id_pelanggan=?;";
           
        java.util.Date cek_in_util = p.getCek_in();
        java.util.Date cek_out_util = p.getCek_out();
        java.sql.Date cek_in_sql = new java.sql.Date(cek_in_util.getTime());
        java.sql.Date cek_out_sql = new java.sql.Date(cek_out_util.getTime());
        try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(9, p.getId());
           ps.setString(1, p.getNama());
           ps.setString(2, p.getJenis_kelamin());
           ps.setString(3, p.getAlamat());
           ps.setString(4, p.getNo_telpon());
           ps.setDate(5,cek_in_sql);
           ps.setDate(6, cek_out_sql);
           ps.setString(7, p.getKamar());
           ps.setInt(8, p.getHarga());
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
    }

    @Override
    public void delete(int id) {
       String query = "DELETE FROM data_pelanggan WHERE id_pelanggan=?;";
       
        try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, id);
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
    }

    @Override
    public List<DataPelanggan> getAll() {
        List<DataPelanggan> list = new ArrayList<>();
       String query = "SELECT * FROM data_pelanggan;";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
                DataPelanggan p = new DataPelanggan();
                
                p.setId(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama_pelanggan"));
                p.setJenis_kelamin(rs.getString("jenis_kelamin"));
                p.setNo_telpon(rs.getString("no_telpon"));
                p.setAlamat(rs.getString("alamat"));
                p.setCek_in(rs.getDate("cek_in"));
                p.setCek_out(rs.getDate("cek_out"));
                p.setKamar(rs.getString("kamar"));
                p.setHarga(rs.getInt("harga"));
                
                list.add(p);
                
           }
       } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
       }
       return list;
   }
    }
    
    
    

