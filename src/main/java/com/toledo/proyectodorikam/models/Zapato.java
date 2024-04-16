package com.toledo.proyectodorikam.models;

public class Zapato extends Producto{

    private String talla;

    public Zapato(String nombre, double precio, String categoria, String ubicacion, String fecha, String id, int stock) {
        super(nombre, precio, categoria, ubicacion, fecha, id, stock);
    }
}
