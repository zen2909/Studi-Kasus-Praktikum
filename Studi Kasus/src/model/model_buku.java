package model;

import entity.entity_buku;

import java.util.ArrayList;

public class model_buku {
    private ArrayList<entity_buku> data_buku;

    public model_buku(){
        data_buku = new ArrayList<entity_buku>();
    }

    public void createbuku(entity_buku buku){
        this.data_buku.add(buku);
    }

    public ArrayList<entity_buku> read() {
        return data_buku;
    }

    public void hapusbuku(int idbuku){
        this.data_buku.remove(idbuku);
    }

    public void editbuku(int idbuku,entity_buku buku){
        this.data_buku.remove(idbuku-1);
        this.data_buku.add(idbuku-1,buku);
    }
}
