package com.toledo.proyectodorikam.models;

public class ApartarProducto {
    private String nombreProducto;
    private double precio;
    private String fechaCompra;
    private String vendedor;
    private String ubicacion;
    private String idProducto;
    private int stock;
    private double montoAbonado;
    private double montoRestante;

    public ApartarProducto(String nombreProducto, double precio, String fechaCompra, String vendedor, String ubicacion, String idProducto, int stock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.vendedor = vendedor;
        this.ubicacion = ubicacion;
        this.idProducto = idProducto;
        this.stock = stock;
        this.montoAbonado = 0;
        this.montoRestante = precio;
    }
     public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public String getVendedor() {
        return vendedor;
    }
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getMontoAbonado() {
        return montoAbonado;
    }
    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }
    public double getMontoRestante() {
        return montoRestante;
    }
    public void setMontoRestante(double montoRestante) {
        this.montoRestante = montoRestante;
    }
}
