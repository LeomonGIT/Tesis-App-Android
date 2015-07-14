package pe.edu.ulima.tesis_app_android.services;

import java.util.ArrayList;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab2DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab3DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab4DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab5DAO;

/**
 * Created by Leonardo on 12/07/2015.
 */
public class ControllerTabs {

    private static ControllerTabs instance;
    private ArrayList<Tab1DAO> arrayTab1;
    private ArrayList<Tab2DAO> arrayTab2;
    private ArrayList<Tab3DAO> arrayTab3;
    private ArrayList<Tab4DAO> arrayTab4;
    private ArrayList<Tab5DAO> arrayTab5;
    public static ControllerTabs getInstance(){
        if(instance==null)
            instance = new ControllerTabs();
        return instance;
    }

    public ControllerTabs() {
        arrayTab1 = new ArrayList<>();
        arrayTab2 = new ArrayList<>();
        arrayTab3 = new ArrayList<>();
        arrayTab4 = new ArrayList<>();
        arrayTab5 = new ArrayList<>();
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

    public ArrayList<Tab3DAO> getArrayTab3() {
        return arrayTab3;
    }

    public void setArrayTab3(ArrayList<Tab3DAO> arrayTab3) {
        this.arrayTab3 = arrayTab3;
    }

    public ArrayList<Tab4DAO> getArrayTab4() {
        return arrayTab4;
    }

    public void setArrayTab4(ArrayList<Tab4DAO> arrayTab4) {
        this.arrayTab4 = arrayTab4;
    }

    public ArrayList<Tab5DAO> getArrayTab5() {
        return arrayTab5;
    }

    public void setArrayTab5(ArrayList<Tab5DAO> arrayTab5) {
        this.arrayTab5 = arrayTab5;
    }
}
