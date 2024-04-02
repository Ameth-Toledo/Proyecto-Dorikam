package com.toledo.proyectodorikam.models;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Apartar {
    private final StringProperty nombre;
    private final StringProperty producto;
    private final IntegerProperty id;
    private final StringProperty fecha;
    private final StringProperty categoria;
    private final StringProperty ubicacion;
    private final IntegerProperty cantidadDeProductos;
    private final DoubleProperty montoAbonado;
    private final DoubleProperty montoRestante;

    private static List<Apartar> listaApartados = new ArrayList<>();

    public Apartar(String nombre, String producto, int id, String fecha, String categoria, String ubicacion,
                   int cantidadDeProductos, double montoAbonado, double montoRestante) {
        this.nombre = new SimpleStringProperty(nombre);
        this.producto = new SimpleStringProperty(producto);
        this.id = new SimpleIntegerProperty(id);
        this.fecha = new SimpleStringProperty(fecha);
        this.categoria = new SimpleStringProperty(categoria);
        this.ubicacion = new SimpleStringProperty(ubicacion);
        this.cantidadDeProductos = new SimpleIntegerProperty(cantidadDeProductos);
        this.montoAbonado = new SimpleDoubleProperty(montoAbonado);
        this.montoRestante = new SimpleDoubleProperty(montoRestante);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getProducto() {
        return producto.get();
    }

    public StringProperty productoProperty() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto.set(producto);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public String getUbicacion() {
        return ubicacion.get();
    }

    public StringProperty ubicacionProperty() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion.set(ubicacion);
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos.get();
    }

    public IntegerProperty cantidadDeProductosProperty() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos.set(cantidadDeProductos);
    }

    public double getMontoAbonado() {
        return montoAbonado.get();
    }

    public DoubleProperty montoAbonadoProperty() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado.set(montoAbonado);
    }

    public double getMontoRestante() {
        return montoRestante.get();
    }

    public DoubleProperty montoRestanteProperty() {
        return montoRestante;
    }

    public void setMontoRestante(double montoRestante) {
        this.montoRestante.set(montoRestante);
    }

    public static void agregarApartado(Apartar apartado) {
        listaApartados.add(apartado);
    }

    public static List<Apartar> getListaApartados() {
        return listaApartados;
    }
}
