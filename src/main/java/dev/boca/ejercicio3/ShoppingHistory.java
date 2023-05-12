package dev.boca.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShoppingHistory extends AppCompatActivity implements ShoppingAdapter.OnCardClickListener {

    private RecyclerView recyclerView;
    private TextView textView;
    private ShoppingAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_history);

        recyclerView = findViewById(R.id.recyclerViewHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingAdapter(this);
        recyclerView.setAdapter(adapter);
        textView = findViewById(R.id.titleNoProducts);
        if(History.historyShopping.size() == 0){
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
    }

    @Override public void onCardClick(int position) {
        CardView cardView = recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.cardView);
        TextView productsShop = recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.productsShop);
        int v = (productsShop.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
        productsShop.setVisibility(v);
    }
}