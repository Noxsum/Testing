package dev.boca.ejercicio3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerView);
        buttonPay = findViewById(R.id.button_pay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter();
        recyclerView.setAdapter(adapter);


        float sumatotal = 0;
        for(Product product: Product.products){
            float precio = product.getPrice();
            int quantity = product.getQuantity();
            sumatotal += (precio * quantity);
        }

        TextView textView = findViewById(R.id.price);

        textView.setText(sumatotal != 0 ? "El precio total es: " + sumatotal + "€" : "No has insertado ningun producto en el carrito");
        if(sumatotal <= 0){
            buttonPay.setVisibility(View.INVISIBLE);
        }

        final float finalSumatotal = sumatotal;

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payMethod(finalSumatotal);
            }
        });
    }

    private void payMethod(final float finalSumatotal) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar un número");
        EditText numberPicker = new EditText(this);
        numberPicker.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(numberPicker);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String aux = String.valueOf(numberPicker.getText());
                DecimalFormat df = new DecimalFormat("#.##");
                float aux2 = Float.parseFloat(aux);
                float selectedValue = Float.parseFloat(df.format(aux2));

                AlertDialog.Builder builder2 = new AlertDialog.Builder(builder.getContext());
                builder2.setTitle(null);
                builder2.setMessage("Total entregado: " + selectedValue + "€\nTotal devuelto: " + (selectedValue - finalSumatotal) + "€");

                builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String productos = "";
                        for(Product product: Product.products){
                            productos += "\n" + product.getQuantity() + "x - " + product.getTitle() + " - " + product.getPrice() + "€/u";
                        }
                        History.historyShopping.add(new History(productos, "Compra " + (History.getHistoryShopping().size() + 1), finalSumatotal));
                        Product.products.clear();
                        Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(intent);
                    }
                });
                builder2.setCancelable(false);
                AlertDialog dialog2 = builder2.create();
                dialog2.show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}