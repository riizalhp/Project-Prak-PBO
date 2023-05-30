/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOPelanggan.DAOPelanggan;
import mainmenu.Pelanggan;
import javax.swing.JOptionPane;
import model.DataPelanggan;
import java.util.ArrayList;
import java.util.List;
import model.ModelTabelDataPelanggan;
import model.DataPelanggan;

/**
 *
 * @author upima
 */
public class DataPelangganController {
    private final Pelanggan menu;
    private final DAOPelanggan dao;
    
    public DataPelangganController(Pelanggan menu){
        this.menu = menu;
        dao = new DAOPelanggan();
    }
    
    public void insert(){
     if (menu.getTNamaPelanggan().getText().trim().isEmpty() ||
            menu.getCek_in().getDate()== null ||
            menu.getCek_out().getDate()== null||
            menu.getTalamat().getText().trim().isEmpty() ||
            menu.getTharga().getText().trim().isEmpty() || 
            menu.getRoom().getSelectedItem().toString().isEmpty() ||
            menu.getTjenis_kelamin().getSelectedItem().toString().isEmpty()){
          
            JOptionPane.showMessageDialog(menu, "Data PELANGGAN tidak boleh kosong!");
        }else{
            DataPelanggan plg = new DataPelanggan();
            
            plg.setNama(menu.getTNamaPelanggan().getText());
            plg.setJenis_kelamin(menu.getTjenis_kelamin().getSelectedItem().toString());
            plg.setNo_telpon(menu.getTnotelpon().getText());
            plg.setAlamat(menu.getTalamat().getText());  
            plg.setCek_in(menu.getCek_in().getDate());
            plg.setCek_out(menu.getCek_out().getDate());
            plg.setKamar(menu.getRoom().getSelectedItem().toString());
            plg.setHarga(Integer.parseInt(menu.getTharga().getText()));
            
            dao.insert(plg);
            JOptionPane.showMessageDialog(menu, "Data PELANGGAN berhasil ditambahkan!");
     }
    }
    
    public void update(){
    
        if (menu.getTNamaPelanggan().getText().trim().isEmpty() ||
            menu.getCek_in().getDate()== null||
            menu.getCek_out().getDate()== null ||
            menu.getTalamat().getText().trim().isEmpty() ||
            menu.getTharga().getText().trim().isEmpty() || 
            menu.getRoom().getSelectedItem().toString().isEmpty() ||
            menu.getTjenis_kelamin().getSelectedItem().toString().isEmpty()){
          
            JOptionPane.showMessageDialog(menu, "Data PELANGGAN tidak boleh kosong!");
        }else{
            DataPelanggan plg = new DataPelanggan();
            plg.setId(Integer.parseInt(menu.getTIdPelanggan().getText()));
            plg.setNama(menu.getTNamaPelanggan().getText());
            plg.setJenis_kelamin(menu.getTjenis_kelamin().getSelectedItem().toString());
            plg.setNo_telpon(menu.getTnotelpon().getText());
            plg.setAlamat(menu.getTalamat().getText());  
            plg.setCek_in(menu.getCek_in().getDate());
            plg.setCek_out(menu.getCek_out().getDate());
            plg.setKamar(menu.getRoom().getSelectedItem().toString());
            plg.setHarga(Integer.parseInt(menu.getTharga().getText()));
            
            dao.update(plg);
            JOptionPane.showMessageDialog(menu, "Data PELANGGAN berhasil ditambahkan!");
     }
    
    }
    public void delete(){
        if(menu.getTIdPelanggan().getText().isEmpty()){
            JOptionPane.showMessageDialog(menu, "di klik dulu datanya yang mau dihapus sayang");
        }else{
         int id = Integer.parseInt(menu.getTIdPelanggan().getText());
            System.out.println(id);
         dao.delete(id);
         JOptionPane.showMessageDialog(menu, "Data PELANGGAN berhasil dihapus!");
                }
    }
    
    
     public void reset() {
        menu.getTIdPelanggan().setText("");
        menu.getTNamaPelanggan().setText("");
        menu.getTnotelpon().setText("");
        menu.getTalamat().setText("");
        menu.getCek_in().setDate(null);
        menu.getCek_out().setDate(null);
        menu.getRoom().setSelectedIndex(1);  
        menu.getTjenis_kelamin().setSelectedIndex(1);
        menu.getTharga().setText("");
       
       
    }

    public void getDatapelangganById(int id) {
        
        DataPelanggan p = dao.getAll().stream()
                                .filter(d -> d.getId() == id)
                                .findFirst()
                                .get();
        menu.getTIdPelanggan().setText(Integer.toString(p.getId()));
        menu.getTNamaPelanggan().setText(p.getNama());
        menu.getTnotelpon().setText(p.getNo_telpon());
        menu.getTjenis_kelamin().setSelectedItem(p.getJenis_kelamin());
        menu.getTalamat().setText(p.getAlamat());
        menu.getCek_in().setDate(p.getCek_in());
        menu.getCek_out().setDate(p.getCek_out());
        menu.getRoom().setSelectedItem(p.getKamar());
        menu.getTharga().setText(Integer.toString(p.getHarga()));
    }

    public void fillTableDataPelanggan() {
        List<DataPelanggan> datapinis = dao.getAll();
        ModelTabelDataPelanggan model = new ModelTabelDataPelanggan((ArrayList<DataPelanggan>) datapinis);

        menu.getTabelPelanggan().setModel(model);
    }
}
