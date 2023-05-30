/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author upima
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelDataPelanggan extends AbstractTableModel {
    
    List<DataPelanggan> dp;
    
    public ModelTabelDataPelanggan(List<DataPelanggan>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "No telpon";
            case 4:
                return "Alamat";
            case 5:
                return "Cek in";
            case 6:
                return "Cek out";
            case 7:
                return "Room";
            case 8:
                return "Harga";
            
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getNama();
            case 2:
                return dp.get(row).getJenis_kelamin();
            case 3:
                return dp.get(row).getNo_telpon();
            case 4:
                return dp.get(row).getAlamat();
            case 5:
                return dp.get(row).getCek_in();
            case 6:
                return dp.get(row).getCek_out();
            case 7:
                return dp.get(row).getKamar();
            case 8:
                return dp.get(row).getHarga();    
            default:
                return null;
        }
    }
    
}
