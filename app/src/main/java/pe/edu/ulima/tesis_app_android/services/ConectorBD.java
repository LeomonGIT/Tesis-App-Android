package pe.edu.ulima.tesis_app_android.services;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Leonardo on 12/07/2015.
 */
public class ConectorBD {

    ControllerTabs controller;

    public ConectorBD() {
        controller = ControllerTabs.getInstance();
    }

    public void getDataPie(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tab1");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                    if(e==null || list != null)
                        for(ParseObject object : list)
                            controller.getTab1().setDato(Integer.parseInt(object.get("Data").toString()));

            }
        });
    }

}
