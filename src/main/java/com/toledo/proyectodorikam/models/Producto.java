package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private String ubicacion;
    private String fecha;
    private String id;

    private static List<Producto> listaProductos = new ArrayList<>();

    public Producto(String nombre, double precio, String categoria, String ubicacion, String fecha, String id) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.id = id;
    }

    public static void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public static void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
    }

    public static List<Producto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
