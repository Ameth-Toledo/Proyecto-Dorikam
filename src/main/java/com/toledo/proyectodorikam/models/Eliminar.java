package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

public class Eliminar {
    private static List<Eliminar> lista = new ArrayList<>();

    static {
        lista.add(new Eliminar("22234","manzana",1,"arete","tonala","22/09/2024",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
        lista.add(new Eliminar("","",1,"","","",2));
    }

    private String idProducto;
    private String nombreProducto;
    private String categoria;
    private double precio;
    private String ubicacion;
    private String fecha;
    private int cantidad;

    public Eliminar(String idProducto, String nombreProducto, double precio, String categoria, String ubicacion, String fecha, int cantidad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public static List<Eliminar> getLista() {
        return lista;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static void eliminarProducto(String nombreProducto) {
        Eliminar producto = obtenerProductoPorNombre(nombreProducto);

        if (producto != null) {
            lista.remove(producto);
            mostrarAlerta("Producto eliminado", "El producto ha sido eliminado correctamente.");
        } else {
            mostrarAlertaError("Error", "El producto no está disponible en la lista.");
        }
    }

    private static Eliminar obtenerProductoPorNombre(String nombre) {
        for (Eliminar producto : lista) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private static void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private static void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
