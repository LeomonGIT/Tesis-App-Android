package pe.edu.ulima.tesis_app_android.services;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;

/**
 * Created by Leonardo on 12/07/2015.
 */
public class ControllerTabs {

    private static ControllerTabs instance;
    private Tab1DAO tab1;
    public static ControllerTabs getInstance(){
        if(instance==null)
            instance = new ControllerTabs();
        return instance;
    }

    public ControllerTabs() {
        tab1 = new Tab1DAO();
    }

    public Tab1DAO getTab1() {
        return tab1;
    }

    public void setTab1(Tab1DAO tab1) {
        this.tab1 = tab1;
    }
}
