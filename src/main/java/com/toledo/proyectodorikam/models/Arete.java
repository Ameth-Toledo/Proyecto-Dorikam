package com.toledo.proyectodorikam.models;
public class Arete {
    private String nombre;
    private String ID;
    private int precio;
    private String apartado;
    private String FechaEntrega;
    public Arete(String nombre, int precio, String ID, String apartado, String FechaEntrega){
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.apartado = apartado;
        this.FechaEntrega = FechaEntrega;
    }

    public String getNombre() {
        return nombre;
    }
    public String getID() {
        return ID;
    }
    public int getPrecio() {
        return precio;
    }
    public String getApartado() {
        return apartado;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    @Override
    public String toString() {
        return "Arete{" +
                "nombre='" + nombre + '\'' +
                ", ID='" + ID + '\'' +
                ", precio=" + precio +
                ", apartado='" + apartado + '\'' +
                ", FechaEntrega='" + FechaEntrega + '\'' +
                '}';
    }
}
