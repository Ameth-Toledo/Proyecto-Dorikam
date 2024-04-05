package com.toledo.proyectodorikam.models;

public class Arete extends Producto {
    private String material;

    public Arete(String nombre, double precio, String categoria, String ubicacion, String fecha, String id, int stock, String material) {
        super(nombre, precio, categoria, ubicacion, fecha, id, stock);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}
