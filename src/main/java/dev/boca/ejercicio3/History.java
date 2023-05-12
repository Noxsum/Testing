package dev.boca.ejercicio3;

import java.util.ArrayList;

public class History {

    public String name;
    public float price;
    public String products;
    public static ArrayList<History> historyShopping = new ArrayList<History>();

    public History(String products, String name, float price) {
        this.name = name;
        this.price = price;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public String getProducts() {
        return products;
    }

    public static ArrayList<History> getHistoryShopping() {
        return historyShopping;
    }

}