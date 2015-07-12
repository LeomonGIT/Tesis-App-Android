package pe.edu.ulima.tesis_app_android;

import android.app.Application;

import com.parse.Parse;

public class Aplicacion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "CentaHKEzjBROCfkWrKZQtIASMw0aYxQi7ERxqn3", "P36hT4pUaYKAz11MqVPIyUEKMK7g01dTqMKN0Ka2");
    }
}
