package com.toledo.proyectodorikam.models;

import javafx.beans.property.*;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Producto producto;
    private final StringProperty nombreProducto;
    private final IntegerProperty cantidad;
    private final StringProperty metodoPago;
    private final StringProperty fechaCompra;
    private final StringProperty nombreCliente;
    private final StringProperty lugarEntrega;
    private final DoubleProperty precioProducto;
    public static List<Venta> listaVentas = new ArrayList<>();

    public Venta(Producto producto, int cantidad, String metodoPago, String nombreProducto, String fechaCompra, String nombreCliente, String lugarEntrega, double precioProducto) {
        this.producto = producto;
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.metodoPago = new SimpleStringProperty(metodoPago);
        this.nombreProducto = new SimpleStringProperty(nombreProducto);
        this.fechaCompra = new SimpleStringProperty(fechaCompra);
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
        this.lugarEntrega = new SimpleStringProperty(lugarEntrega);
        this.precioProducto = new SimpleDoubleProperty(precioProducto);
    }

    public StringProperty nombreProductoProperty() {
        return nombreProducto;
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public StringProperty metodoPagoProperty() {
        return metodoPago;
    }

    public StringProperty fechaCompraProperty() {
        return fechaCompra;
    }

    public StringProperty nombreClienteProperty() {
        return nombreCliente;
    }

    public StringProperty lugarEntregaProperty() {
        return lugarEntrega;
    }

    public DoubleProperty precioProductoProperty() {
        return precioProducto;
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
    public String getNombreProducto() {
        return nombreProducto.get();
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public String getLugarEntrega() {
        return lugarEntrega.get();
    }

    public String getFechaCompra() {
        return fechaCompra.get();
    }

}
