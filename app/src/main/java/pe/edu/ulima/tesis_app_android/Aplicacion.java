package pe.edu.ulima.tesis_app_android;

import android.app.Application;

import com.parse.Parse;

public class Aplicacion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this,"XFTLwHxKt1zFZhVRu8DL5vhc5dmrU0RI7OaS1A0H", "jaqFKTG1IMzI055UZTeTnsWWX0l3wULYtq3VhR7G");
    }
}
