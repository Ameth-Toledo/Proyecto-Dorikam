package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Producto producto;
    private int cantidad;
    private String metodoPago;
    public static List<Venta> listaVentas = new ArrayList<>();

    public Venta(Producto producto, int cantidad, String metodoPago) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "Producto: " + producto +
                ", Cantidad: " + cantidad +
                ", Método de Pago: " + metodoPago + '\'';
    }

    public static List<Venta> getListaVentas() {
        return listaVentas;
    }
}