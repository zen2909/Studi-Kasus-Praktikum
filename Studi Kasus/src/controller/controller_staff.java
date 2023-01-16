package controller;

import Abstraction.interface_staff;
import allobject.object;
import entity.entity_staff;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class controller_staff implements interface_staff {
    @Override
    public ArrayList<entity_staff> read() {
        return object.databasestaff.read();
    }

    @Override
    public boolean tambahstaff(entity_staff staff) {
        try {
            object.databasestaff.createstaff(staff);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean cekLogin(String username, int pin) {

        try {
            for (int i = 0; i < object.staff.size(); i++) {
                object.databasestaff.ceklogin(username, pin);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public DefaultTableModel liststaff() {
        DefaultTableModel daftarstaff = new DefaultTableModel();
        Object[] kolom = {"Username", "Pin"};
        daftarstaff.setColumnIdentifiers(kolom);

        int size = object.staff.size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[2];
            data[0] = object.staff.get(i).getUsername();
            data[1] = object.staff.get(i).getPin();
            daftarstaff.addRow(data);

        }
        return daftarstaff;
    }
}
