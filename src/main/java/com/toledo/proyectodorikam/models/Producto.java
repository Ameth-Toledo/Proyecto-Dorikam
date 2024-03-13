package com.toledo.proyectodorikam.models;

public class Producto {
    private String nombreProducto;
    private double precioProducto;
    private String fechaCompra;
    private String nombreCliente;
    private String lugarEntrega;
    private String IDProducto;
    private int stock;

    public Producto(String nombreProducto, double precioProducto, String fechaCompra, String nombreCliente, String lugarEntrega, String IDProducto, int stock) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.fechaCompra = fechaCompra;
        this.nombreCliente = nombreCliente;
        this.lugarEntrega = lugarEntrega;
        this.IDProducto = IDProducto;
        this.stock = stock;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
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

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}