package com.toledo.proyectodorikam.models;

public class Arete extends Producto{

    private String material;

    public Arete(String nombre, double precio, String categoria, String ubicacion, String fecha, String id, int stock) {
        super(nombre, precio, categoria, ubicacion, fecha, id, stock);
    }
}