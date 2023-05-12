package dev.boca.ejercicio3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.gms.ads.AdView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView emailTextView;
    private TextView surnameTextview;

    private TextView nameTextview;
    private SwitchCompat premiumSwitch;
    private Button historyButton;
    private String email;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Obtener la instancia de MyApplication
        MyApplication myApp = (MyApplication) getApplication();

        // Referencias a los elementos del layout
        profileImage = findViewById(R.id.profile_image);
        emailTextView = findViewById(R.id.email_textview);
        premiumSwitch = findViewById(R.id.premium_switch);
        historyButton = findViewById(R.id.history_button);
        nameTextview = findViewById(R.id.name_textview);
        surnameTextview = findViewById(R.id.surname_textview);

        // Obtener el correo electrónico del usuario
        String email = GlobalVariables.getInstance().getUserEmail();
        emailTextView.setText(email);
        nameTextview.setText(Profile.getName());
        surnameTextview.setText(Profile.getSurname());
        // Obtener el valor del SwitchCompat desde MyApplication
        boolean switchValue = myApp.getSwitchValue();


        // Establecer el estado del SwitchCompat
        premiumSwitch.setChecked(switchValue);

        // Configuración del switch
        premiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Actualizar el valor de switchValue en MyApplication
                myApp.setSwitchValue(isChecked);
            }
        });

        // Configuración del botón
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ShoppingHistory.class);
                startActivity(intent);
            }
        });
    }

    public String getEmail() {
        return email;
    }
}