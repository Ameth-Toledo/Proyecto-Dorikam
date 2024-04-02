package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Producto producto;
    private int cantidad;
    private String metodoPago;
    private String nombreProducto;
    private String fechaCompra;
    private String nombreCliente;
    private String lugarEntrega;
    private double precioProducto;
    public static List<Venta> listaVentas = new ArrayList<>();

    public Venta(Producto producto, int cantidad, String metodoPago, String nombreProducto, String fechaCompra, String nombreCliente, String lugarEntrega, double precioProducto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
        this.nombreProducto = nombreProducto;
        this.fechaCompra = fechaCompra;
        this.nombreCliente = nombreCliente;
        this.lugarEntrega = lugarEntrega;
        this.precioProducto = precioProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public static List<Venta> getListaVentas() {
        return listaVentas;
    }

    @Override
    public String toString() {
        return "Venta: " +
                "Producto: " + producto +
                ", Cantidad: " + cantidad +
                ", Método de Pago: " + metodoPago + '\'' +
                ", Nombre del Producto: " + nombreProducto + '\'' +
                ", Fecha de Compra: " + fechaCompra + '\'' +
                ", Nombre del Cliente: " + nombreCliente + '\'' +
                ", Lugar de Entrega: " + lugarEntrega + '\'' +
                ", Precio del Producto=" + precioProducto;
    }
}