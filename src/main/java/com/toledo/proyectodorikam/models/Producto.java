package com.toledo.proyectodorikam.models;

public class Producto {
    private String NombreProducto;
    private double PrecioProducto;
    private String FechaCompra;
    private String NombreCliente;
    private String LugarEntrega;
    private String IDProducto;
    private int stock;
    public Producto(String nombreProducto, double precioProducto, String fechaCompra, String nombreCliente, String lugarEntrega, String idProducto, int stock) {
        this.NombreProducto = nombreProducto;
        this.PrecioProducto = precioProducto;
        this.FechaCompra = fechaCompra;
        this.NombreCliente = nombreCliente;
        this.LugarEntrega = lugarEntrega;
        this.IDProducto = idProducto;
        this.stock = stock;
    }
    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.NombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.PrecioProducto = precioProducto;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.FechaCompra = fechaCompra;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.NombreCliente = nombreCliente;
    }

    public String getLugarEntrega() {
        return LugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.LugarEntrega = lugarEntrega;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String idProducto) {
        this.IDProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
