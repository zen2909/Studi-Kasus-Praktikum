package model;

import allobject.object;
import entity.entity_buku;
import entity.entity_staff;

import java.util.ArrayList;

public class model_staff {

   private ArrayList<entity_staff> staff;

    public model_staff() {
        staff = new ArrayList<entity_staff>();
    }

    public void createstaff(entity_staff staff){
        this.staff.add(staff);
    }
    public ArrayList<entity_staff> read(){
        return staff;
    }
    public void ceklogin(String username, int pin){
        boolean cek;
        int i=0;
        do {
            if (!username.equals(object.staff.get(i).getUsername())){
                cek = false;
                i++;
                if (pin!=object.staff.get(i).getPin()){
                }
            }else if (pin != object.staff.get(i).getPin()) {
                cek = false;
                i++;
            }else{
                cek = true;
            }
        }while(cek!=true);
    }
}
