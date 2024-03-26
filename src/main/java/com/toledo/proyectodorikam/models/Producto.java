package com.toledo.proyectodorikam.models;

public class Producto {
    private String NombreProducto;
    private double PrecioProducto;
    private String FechaCompra;
    private String NombreCliente;
    private String LugarEntrega;
    private String IDProducto;
    private int stock;
    private String Categoria;

    public Producto(String nombreProducto, double precioProducto, String fechaCompra, String nombreCliente, String lugarEntrega, String IDProducto, int stock, String categoria) {
        this.NombreProducto = nombreProducto;
        this.PrecioProducto = precioProducto;
        this.FechaCompra = fechaCompra;
        this.NombreCliente = nombreCliente;
        this.LugarEntrega = lugarEntrega;
        this.IDProducto = IDProducto;
        this.stock = stock;
        this.Categoria = categoria;
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

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
