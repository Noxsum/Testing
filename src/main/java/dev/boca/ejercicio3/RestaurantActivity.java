package dev.boca.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }

    public void openRestaurantBarna(View view) {
        String uri = "geo:0,0?q=" + "Diagonal Mar Tranvía L'Illa, Avinguda Diagonal, s/n, Centro Comercial, 08019 Barcelona";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void openRestaurantHospi(View view) {
        String uri = "geo:0,0?q=" + "Carrer de Barcelona, 2, 08901 L'Hospitalet de Llobregat, Barcelona";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void openRestaurantTarraco(View view) {
        String uri = "geo:0,0?q=" + "Rambla Nova, 44, 43004 Tarragona";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}