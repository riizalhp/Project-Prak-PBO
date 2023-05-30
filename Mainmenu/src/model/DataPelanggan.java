/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author upima
 */
public class DataPelanggan {
    private int id ;
    private String nama;
    private String jenis_kelamin;
    private String no_telpon;
    private String alamat;
    private Date cek_in;//01012023
    private Date cek_out;//03012023
    private String kamar;
    private int harga;
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setId(int id){
    this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    
    public void setJenis_kelamin(String jenis_kelamin){
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public String getJenis_kelamin(){
        return jenis_kelamin;
    }
    
    public void setNo_telpon(String no_telpon){
        this.no_telpon = no_telpon;
    }
    
    public String getNo_telpon(){
        return no_telpon;
    }
    
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    
     public void setCek_in(Date cek_in){
        this.cek_in = cek_in;
    }
    
    public Date getCek_in(){
        return cek_in;
    }
    
      public void setCek_out(Date cek_out){
        this.cek_out = cek_out;
    }
    
    public Date getCek_out(){
        return cek_out;
    }
    


     public void setKamar(String kamar){
        this.kamar = kamar;
    }
    
    public String getKamar(){
        return kamar;
    }
    
    public void setHarga(int harga){
     this.harga = harga;
    }
    
    public int getHarga(){
    return harga;
    }
}
