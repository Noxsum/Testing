package dev.boca.ejercicio3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    ArrayList<Product> products;
    public CartAdapter() {
        this.products = Product.getProducts();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_product_cart, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(
            products.get(position).getTitle(),
            products.get(position).getQuantity(),
            products.get(position).getPrice()
        );
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private TextView quantityText;
        private TextView priceText;
        public MyViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_product);
            quantityText = itemView.findViewById(R.id.quantity_product);
            priceText = itemView.findViewById(R.id.price_product);
        }
        public void bind(String text, int quantity, float price) {
            nameText.setText(text);
            quantityText.setText(quantity + "x");
            priceText.setText(price + "€");
        }
    }
}
