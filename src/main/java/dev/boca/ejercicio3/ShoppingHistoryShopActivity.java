package dev.boca.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.opengl.Visibility;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingHistoryShopActivity extends AppCompatActivity {

    private CardView cardView;
    private LinearLayout expandableLayout;
    private TextView title;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_history_shop);

        cardView = findViewById(R.id.cardView);
        expandableLayout = findViewById(R.id.expandableLayout);
        title = findViewById(R.id.titleShop);
        description = findViewById(R.id.productsShop);

    }


}