package pe.edu.ulima.tesis_app_android.services;

import java.util.ArrayList;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;

/**
 * Created by Leonardo on 12/07/2015.
 */
public class ControllerTabs {

    private static ControllerTabs instance;
    private ArrayList<Tab1DAO> arrayTab1;
    public static ControllerTabs getInstance(){
        if(instance==null)
            instance = new ControllerTabs();
        return instance;
    }

    public ControllerTabs() {
        arrayTab1 = new ArrayList<>();
    }

    public ArrayList<Tab1DAO> getArrayTab1() {
        return arrayTab1;
    }

    public void setArrayTab1(ArrayList<Tab1DAO> arrayTab1) {
        this.arrayTab1 = arrayTab1;
    }
}
