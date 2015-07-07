package pe.edu.ulima.tesis_app_android.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.MainMenuActivity;


public class Login extends ActionBarActivity {

    ImageView iv;
    EditText txtUser;
    EditText txtPass;
    Button ingresar;
    private String user, pass;
    private ProgressDialog pd = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser=(EditText) findViewById(R.id.user);
        txtPass=(EditText) findViewById(R.id.password);
        iv = (ImageView) findViewById(R.id.img_titulo);
        ingresar = (Button) findViewById(R.id.btnLogin);

    }

    public void clickLogin(View v) {
        user = txtUser.getText().toString();
        pass = txtPass.getText().toString();
        pd = ProgressDialog.show(this, "Conectando al Servidor",
                "Espere unos segundos...", true, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 200);
        if (!user.equalsIgnoreCase("") || !pass.equalsIgnoreCase("")) {
            Log.e("user/pass", user + "/" + pass);
            ParseUser.logInInBackground(user, pass, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (parseUser != null)
                        login();
                    else
                        Toast.makeText(Login.this,"Usuario y/o Password no valido",Toast.LENGTH_LONG).show();
                    pd.dismiss();
                }
            });
        }
        else{
            Toast.makeText(this,"Campos no pueden ser vacios",Toast.LENGTH_SHORT).show();
            pd.dismiss();
        }



    }
    private void login(){
        Intent i=null;
        i = new Intent(Login.this, MainMenuActivity.class);
        startActivity(i);
    };
}
