package dev.boca.ejercicio3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {


    //Creo todos los elementos que voy a necesitar para este login.

    EditText username;
    EditText password;
    MaterialButton ok;
    CheckBox check;
    private String user, pass;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor ;
    private boolean recordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inicializo los elementos, con el uso de findViewById y la id del elemento.
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        ok = (MaterialButton) findViewById(R.id.btnentrar);
        check = (CheckBox) findViewById(R.id.checkBox);
        preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        editor = preferences.edit();

        recordar = preferences.getBoolean("recordar", false);

        if (recordar == true) {
            username.setText(preferences.getString("username", ""));
            password.setText(preferences.getString("password", ""));
            check.setChecked(true);

        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(username.getWindowToken(), 0);

                user = username.getText().toString();
                pass = password.getText().toString();

                if (check.isChecked()) {
                    editor.putBoolean("recordar", true);
                    editor.putString("username", user);
                    editor.putString("password", pass);
                    editor.apply();
                } else {
                    editor.clear();
                    editor.apply();
                }
            }


        });

        //Creo un listener en el botón de entrar.
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Si el usuario y la contraseña introducidos coinciden con los del código...
                if(username.getText().toString().equalsIgnoreCase("") || password.getText().toString().equalsIgnoreCase("")) seeAlertDialog(0);
                else if(!username.getText().toString().equalsIgnoreCase("1")) seeAlertDialog(1);
                else if(!password.getText().toString().equalsIgnoreCase("1")) seeAlertDialog(2);
                else seeAlertDialog(-1);
            }

            public void seeAlertDialog(int msg){
                String title = "", message = "";

                if(msg == 0) {
                    title = "Datos no introducidos";
                    message = "No has introducido tu correo electronico o tu contraseña";
                }else if(msg == 1){
                    title = "Correo electronico incorrecto";
                    message = "El correo electronico que has introducido es incorrecto.";
                }else if(msg == 2){
                    title = "Contraseña incorrecta.";
                    message = "La contraseña que has introducido es incorrecto";
                }else{
                    String userName = username.getText().toString();
                    GlobalVariables.getInstance().setUserEmail(userName);
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.setPositiveButton("Aceptar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    };
};