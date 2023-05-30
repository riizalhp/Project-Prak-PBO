/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author upima
 */
public class Koneksi {
    static Connection con;
    
        public static Connection koneksi(){
            
            
            if(con == null){
            MysqlDataSource data = new MysqlDataSource(); 
            data.setDatabaseName("projek_pbo");
            data.setUser("root");
            data.setPassword("");
            
                try{
                    con =  data.getConnection();
                    System.out.println("koneksi Berhasil");
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("Koneksi Kagal");
                }
            }
            
        return con;
        }
    
}
