package com.toledo.proyectodorikam.models;

public class Zapato extends Producto {
    private double talla;

    public Zapato(String nombre, double precio, String categoria, String ubicacion, String fecha, String id, int stock, double talla) {
        super(nombre, precio, categoria, ubicacion, fecha, id, stock);
        this.talla = talla;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return super.toString() + ", Talla: " + talla;
    }
}
