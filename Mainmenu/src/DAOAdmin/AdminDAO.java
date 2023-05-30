/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DataAdmin;
import koneksi.Koneksi;
//import static koneksi.Koneksi.koneksi;
/**
 *
 * @author upima
 */
public class AdminDAO {
    
    public DataAdmin loginAdmin(String username, String password) throws SQLException{
         Connection con = koneksi.Koneksi.koneksi();
         
         DataAdmin data = null;
         String query = "SELECT * FROM login WHERE username=? AND password=?";
         
            try (PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1, username);
                ps.setString(2, password);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    data = new DataAdmin();
                    data.setUsername(rs.getString("username"));
                    data.setPassword(rs.getString("password"));
                }
                rs.close();
            }
         return data;
    }
    
    
   
}
