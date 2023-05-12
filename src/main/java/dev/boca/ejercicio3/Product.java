package dev.boca.ejercicio3;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;

public class Product {

    public static ArrayList<Product> products = new ArrayList<>();

    private String title;
    private float price;
    private int quantity;

    public Product(){
    }

    public Product(String title, float price){
        this.title = title;
        this.price = price;
        this.quantity = 1;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void addQuantity(){
        quantity++;
    }

    public static void addProduct(String title, float price){
        for(Product product : products){
            if(title.equalsIgnoreCase(product.getTitle())){
                product.addQuantity();
                return;
            }
        }
        Product.products.add(new Product(title, price));
    }

    public static ArrayList<Product> getProducts(){
        return products;
    }

    public static void crearPregunta(Activity activity, String nombreProducto, float precio){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(nombreProducto);
        builder.setMessage("¿Quieres añadir este producto al carrito por " + precio+ "€?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Product.addProduct(nombreProducto, precio);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
