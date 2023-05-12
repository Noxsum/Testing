package dev.boca.ejercicio3;

import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.transition.AutoTransition;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder> {

    ArrayList<History> history;
    OnCardClickListener listener;

    public ShoppingAdapter(OnCardClickListener listener) {
        this.history = History.historyShopping;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_shopping_history_shop, parent, false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(
                history.get(position).getName(),
                history.get(position).getPrice(),
                history.get(position).getProducts()
        );
        Log.d("Productos", "Trabajando: " + history.get(position).getName());
        Log.d("Productos", "Productos: " + history.get(position).getProducts());

    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView productsShop;
        private CardView cardView;
        OnCardClickListener listener;

        public MyViewHolder(@NonNull View itemView, OnCardClickListener listener) {
            super(itemView);
            productsShop = itemView.findViewById(R.id.productsShop);
            title = itemView.findViewById(R.id.titleShop);
            cardView = itemView.findViewById(R.id.cardView);
            this.listener = listener;
            cardView.setOnClickListener(this);
        }

        public void bind(String name, float price, String products){
            title.setText(name + " - " + price + "€");
            Log.d("prueba", products);
            productsShop.setText(products);
        }

        @Override
        public void onClick(View v) {
            int position = getPosition();
            Log.d("Prueba", "Posicion:" + position);
            if (position != RecyclerView.NO_POSITION) {
                listener.onCardClick(position);
            }
        }
    }

    public interface OnCardClickListener {
        void onCardClick(int position);
    }
}