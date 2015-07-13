package pe.edu.ulima.tesis_app_android.services;

import java.util.ArrayList;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab2DAO;

/**
 * Created by Leonardo on 12/07/2015.
 */
public class ControllerTabs {

    private static ControllerTabs instance;
    private ArrayList<Tab1DAO> arrayTab1;
    private ArrayList<Tab2DAO> arrayTab2;
    public static ControllerTabs getInstance(){
        if(instance==null)
            instance = new ControllerTabs();
        return instance;
    }

    public ControllerTabs() {
        arrayTab1 = new ArrayList<>();
        arrayTab2 = new ArrayList<>();
    }

    public ArrayList<Tab1DAO> getArrayTab1() {
        return arrayTab1;
    }

    public void setArrayTab1(ArrayList<Tab1DAO> arrayTab1) {
        this.arrayTab1 = arrayTab1;
    }

    public ArrayList<Tab2DAO> getArrayTab2() {
        return arrayTab2;
    }

    public void setArrayTab2(ArrayList<Tab2DAO> arrayTab2) {
        this.arrayTab2 = arrayTab2;
    }
}
