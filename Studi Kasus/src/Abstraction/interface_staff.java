package Abstraction;

import entity.entity_staff;

import java.util.ArrayList;

public interface interface_staff {
    ArrayList<entity_staff> read();
    boolean tambahstaff(entity_staff staff);
    boolean cekLogin(String username, int pin);

}
