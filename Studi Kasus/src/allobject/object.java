package allobject;

import controller.controller_buku;
import controller.controller_staff;
import entity.entity_buku;
import entity.entity_staff;
import model.model_buku;
import model.model_staff;

import java.util.ArrayList;

public class object {
    public static model_buku databasebuku = new model_buku();
    public static controller_buku controllerbuku = new controller_buku();
    public static ArrayList<entity_buku> buku = controllerbuku.read();
    public static model_staff databasestaff = new model_staff();
    public static controller_staff controllerstaff = new controller_staff();
    public static ArrayList<entity_staff> staff = controllerstaff.read();

}
