package pe.edu.ulima.tesis_app_android.services;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab2DAO;

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
                        ArrayList<Tab1DAO> temp = new ArrayList<>();
                        for(ParseObject object : list){
                            Tab1DAO tab1 =  new Tab1DAO(Integer.parseInt(object.get("Data").toString()),
                                    object.get("Dia").toString());
                            temp.add(tab1);
                            Log.e("Add to array is:" , tab1.toString());
                        }
                        controller.setArrayTab1(temp);
                        conector.getDataFromBI();
                    }


            }
        });
    }

    public void getDataForTab2(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab2");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e==null || list != null){
                    ArrayList<Tab2DAO> temp = new ArrayList<>();
                    for(ParseObject object : list){
                        Tab2DAO tab2 =  new Tab2DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("dia").toString());
                        temp.add(tab2);
                        Log.e("Add to array is:" , tab2.toString());
                    }
                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                }
            }
        });
    }

    public void getDataForTab3(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab3");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e==null || list != null){
                    ArrayList<Tab2DAO> temp = new ArrayList<>();
                    for(ParseObject object : list){
                        Tab2DAO tab2 =  new Tab2DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("dia").toString());
                        temp.add(tab2);
                        Log.e("Add to array is:" , tab2.toString());
                    }
                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                }
            }
        });
    }

    public void getDataForTab4(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab4");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e==null || list != null){
                    ArrayList<Tab2DAO> temp = new ArrayList<>();
                    for(ParseObject object : list){
                        Tab2DAO tab2 =  new Tab2DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("dia").toString());
                        temp.add(tab2);
                        Log.e("Add to array is:" , tab2.toString());
                    }
                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                }
            }
        });
    }

    public void getDataForTab5(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab5");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e==null || list != null){
                    ArrayList<Tab2DAO> temp = new ArrayList<>();
                    for(ParseObject object : list){
                        Tab2DAO tab2 =  new Tab2DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("dia").toString());
                        temp.add(tab2);
                        Log.e("Add to array is:" , tab2.toString());
                    }
                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                }
            }
        });
    }

}
