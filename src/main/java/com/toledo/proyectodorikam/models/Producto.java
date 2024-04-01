package com.toledo.proyectodorikam.models;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private final StringProperty nombre;
    private final DoubleProperty precio;
    private final StringProperty categoria;
    private final StringProperty ubicacion;
    private final StringProperty fecha;
    private final StringProperty id;

    private static List<Producto> listaProductos = new ArrayList<>();
    private static List<Producto> copiaListaProductos = new ArrayList<>();
    public Producto(String nombre, double precio, String categoria, String ubicacion, String fecha, String id) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.categoria = new SimpleStringProperty(categoria);
        this.ubicacion = new SimpleStringProperty(ubicacion);
        this.fecha = new SimpleStringProperty(fecha);
        this.id = new SimpleStringProperty(id);
    }

    public static void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        copiaListaProductos = new ArrayList<>(listaProductos);
    }

    public static void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
        copiaListaProductos = new ArrayList<>(listaProductos);
    }

    public static List<Producto> getListaProductos() {
        return listaProductos;
    }

    public static List<Producto> getCopiaListaProductos() {
        return new ArrayList<>(copiaListaProductos);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public StringProperty ubicacionProperty() {
        return ubicacion;
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public StringProperty idProperty() {
        return id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre.get() + '\'' +
                ", precio=" + precio.get() +
                ", categoria='" + categoria.get() + '\'' +
                ", ubicacion='" + ubicacion.get() + '\'' +
                ", fecha='" + fecha.get() + '\'' +
                ", id='" + id.get() + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public String getUbicacion() {
        return ubicacion.get();
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion.set(ubicacion);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
