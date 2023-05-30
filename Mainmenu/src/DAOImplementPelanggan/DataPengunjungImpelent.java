/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplementPelanggan;
import java.util.List;
import model.DataPelanggan;
/**
 *
 * @author upima
 */
public interface DataPengunjungImpelent {
    public void insert(DataPelanggan p);
    
    public void update(DataPelanggan p);
    
    public void delete(int id);
    
    public List<DataPelanggan> getAll();
}
