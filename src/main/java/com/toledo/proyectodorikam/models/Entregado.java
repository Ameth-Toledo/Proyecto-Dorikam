package com.toledo.proyectodorikam.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Entregado {
    private final StringProperty nombreProducto;
    private final IntegerProperty cantidad;
    private final StringProperty idProducto;
    private final DoubleProperty montoAbonado;
    private final DoubleProperty restante;
    private final StringProperty lugarEntrega;
    private final StringProperty fechaCompra;
    private final StringProperty categoria;
    private final StringProperty metodoPago;

    private static ObservableList<Entregado> listaEntregados = FXCollections.observableArrayList();

    public Entregado(String nombreProducto, String idProducto, int cantidad, double montoAbonado, double restante,
                      String lugarEntrega, String fechaCompra, String categoria, String metodoPago) {
        this.nombreProducto = new SimpleStringProperty(nombreProducto);
        this.idProducto = new SimpleStringProperty(idProducto);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.montoAbonado = new SimpleDoubleProperty(montoAbonado);
        this.restante = new SimpleDoubleProperty(restante);
        this.lugarEntrega = new SimpleStringProperty(lugarEntrega);
        this.fechaCompra = new SimpleStringProperty(fechaCompra);
        this.categoria = new SimpleStringProperty(categoria);
        this.metodoPago = new SimpleStringProperty(metodoPago);
    }

    public String getNombreProducto() {
        return nombreProducto.get();
    }

    public StringProperty nombreProductoProperty() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public String getIdProducto() {
        return idProducto.get();
    }

    public StringProperty idProductoProperty() {
        return idProducto;
    }

    public double getMontoAbonado() {
        return montoAbonado.get();
    }

    public DoubleProperty montoAbonadoProperty() {
        return montoAbonado;
    }

    public double getRestante() {
        return restante.get();
    }

    public DoubleProperty restanteProperty() {
        return restante;
    }

    public String getLugarEntrega() {
        return lugarEntrega.get();
    }

    public StringProperty lugarEntregaProperty() {
        return lugarEntrega;
    }

    public String getFechaCompra() {
        return fechaCompra.get();
    }

    public StringProperty fechaCompraProperty() {
        return fechaCompra;
    }

    public String getCategoria() {
        return categoria.get();
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public String getMetodoPago() {
        return metodoPago.get();
    }

    public StringProperty metodoPagoProperty() {
        return metodoPago;
    }

    public static void agregarEntregado(Entregado entregado) {
        listaEntregados.add(entregado);
    }

    public static ObservableList<Entregado> getListaEntregados() {
        return listaEntregados;
    }

    private Producto producto;

}
