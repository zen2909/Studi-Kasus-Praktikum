package controller;

import Abstraction.interface_buku;
import allobject.object;
import entity.entity_buku;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class controller_buku implements interface_buku {
    @Override
    public ArrayList<entity_buku> read() {
        return object.databasebuku.read();
    }

    @Override
    public boolean tambahbuku(entity_buku buku) {
        try{
            object.databasebuku.createbuku(buku);
            return true;
        } catch (ArrayStoreException e){
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listbuku() {
        DefaultTableModel daftarbuku = new DefaultTableModel();
        Object[] kolom = {"No","Judul", "Penulis","Tahun Terbit"};
        daftarbuku.setColumnIdentifiers(kolom);

        int size = object.buku.size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = i+1;
            data[1] = object.buku.get(i).getNamabuku();
            data[2] = object.buku.get(i).getPencipta();
            data[3] = object.buku.get(i).getTahunterbit();
            daftarbuku.addRow(data);

        }
        return daftarbuku;
    }


    @Override
    public boolean hapusbuku(int idbuku) {
        try{
            object.databasebuku.hapusbuku(idbuku-1);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean editbuku(int idbuku, entity_buku buku) {
        try{
            object.databasebuku.editbuku(idbuku, buku);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
