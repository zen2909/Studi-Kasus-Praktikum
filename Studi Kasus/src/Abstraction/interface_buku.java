package Abstraction;

import entity.entity_buku;
import entity.entity_staff;

import java.util.ArrayList;

public interface interface_buku {
    ArrayList<entity_buku> read();
    boolean tambahbuku(entity_buku buku);
    boolean hapusbuku(int idbuku);
    boolean editbuku(int idbuku,entity_buku buku);
}
