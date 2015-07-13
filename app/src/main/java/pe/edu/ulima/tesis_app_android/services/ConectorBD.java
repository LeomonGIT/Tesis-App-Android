package pe.edu.ulima.tesis_app_android.services;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;

public class ConectorBD{

    ControllerTabs controller;
    private ConectorBDInterface conector;

    public ConectorBD(ConectorBDInterface conectorIF) {
        this.conector = conectorIF;
        controller = ControllerTabs.getInstance();
    }

    public void calledFromConector(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab1");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                    if(e==null || list != null){
                        for(ParseObject object : list){
                            Tab1DAO tab1 =  new Tab1DAO(Integer.parseInt(object.get("Data").toString()),
                                    object.get("Dia").toString());
                            controller.getArrayTab1().add(tab1);
                            Log.e("Add to array is:" , tab1.toString());
                        }
                        conector.getDataPie();
                    }


            }
        });
    }

}
