package pe.edu.ulima.tesis_app_android.services;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pe.edu.ulima.tesis_app_android.DAO.Tab1DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab2DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab3DAO;
import pe.edu.ulima.tesis_app_android.DAO.Tab4DAO;

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
                ArrayList<Tab2DAO> temp = new ArrayList<>();
                if(e==null && list.size()>0){
                    Log.e("getDataForTab2 2:" , "list not null");
                    for(ParseObject object : list){
                        Tab2DAO tab2 =  new Tab2DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("dia").toString());
                        temp.add(tab2);
                        Log.e("Add to array is:" , tab2.toString());
                    }
                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                }else{
                    Random rand = new Random();
                    for (int i = 0; i < 6; i++) {
                        int randomNum = rand.nextInt((24 - 0) + 1) + 0;
                        Tab2DAO tab2 =  new Tab2DAO(randomNum,
                                "dia");
                        temp.add(tab2);
                        Log.e("Add to temp is:", tab2.toString());
                    }

                    controller.setArrayTab2(temp);
                    conector.getDataFromBI();
                    //e.printStackTrace();
                }
            }
        });
    }

    public void getDataForTab3(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab3");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                ArrayList<Tab3DAO> temp = new ArrayList<>();
                if(e==null && list.size()>0){
                    for(ParseObject object : list){
                        Tab3DAO tab3 =  new Tab3DAO(object.get("dia").toString(),Integer.parseInt(object.get("data").toString()),
                                Float.parseFloat(object.get("porcentaje").toString()));
                        temp.add(tab3);
                        Log.e("Add to array is:" , tab3.toString());
                    }
                    controller.setArrayTab3(temp);
                    conector.getDataFromBI();
                }else{
                    Random rand = new Random();
                    int data[]=new int[4];
                    float porcentaje[];
                    for (int i = 0; i < 4; i++) {
                        data[i] = rand.nextInt((24 - 0) + 1) + 0;
                    }
                    porcentaje = calcularPorcentajeTab3(data);
                    for (int i = 0; i < 4; i++) {
                        Tab3DAO tab3 =  new Tab3DAO("dia",data[i],porcentaje[i]);
                        temp.add(tab3);
                        Log.e("Add to temp is:", tab3.toString());
                    }

                    controller.setArrayTab3(temp);
                    conector.getDataFromBI();
                    //e.printStackTrace();
                }
            }
        });
    }
    private float[] calcularPorcentajeTab3(int data[]){
        float porcen[] = new float[4];
        int acum = 0;
        for (int i = 0; i <4 ; i++) {
            acum += data[i];
        }
        Log.e("acum", "" + acum);
        for (int i = 0; i <4 ; i++) {
            porcen[i]=(float)data[i]/acum*100;
            Log.e("porcen["+i+"] =",""+porcen[i]);
        }
        return porcen;
    }

    public void getDataForTab4(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab4");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                ArrayList<Tab4DAO> temp = new ArrayList<>();
                if(e==null && list.size()>0){
                    for(ParseObject object : list){
                        Tab4DAO tab4 =  new Tab4DAO(Integer.parseInt(object.get("data").toString()),
                                object.get("mes").toString());
                        temp.add(tab4);
                        Log.e("Add to array is:" , tab4.toString());
                    }
                    controller.setArrayTab4(temp);
                    conector.getDataFromBI();
                }else {
                    Random rand = new Random();
                    for (int i = 0; i < 12; i++) {
                        int randomNum = rand.nextInt((1200 - 0) + 1) + 0;
                        Tab4DAO tab4 = new Tab4DAO(randomNum,"mes");
                        temp.add(tab4);
                        Log.e("Add to temp is:", tab4.toString());
                    }
                    controller.setArrayTab4(temp);
                    conector.getDataFromBI();
                    //e.printStackTrace();
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
