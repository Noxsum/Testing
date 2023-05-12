package dev.boca.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MenuActivity extends AppCompatActivity {

    private AdView mAdView;
    private boolean switchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MyApplication myApp = (MyApplication) getApplication();
        switchValue = myApp.getSwitchValue();


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (switchValue) {
            mAdView.setVisibility(View.GONE);
        } else {
            mAdView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_cart){
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.action_profile){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public void showProducts(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        startActivity(intent);
    }

    public void showRestaurants(View view) {
        Intent intent = new Intent(this, RestaurantActivity.class);
        startActivity(intent);
    }
}