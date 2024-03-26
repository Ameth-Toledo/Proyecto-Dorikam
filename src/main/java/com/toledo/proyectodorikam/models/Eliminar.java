package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;

public class Eliminar {
    private static List<Producto> listaProductos = new ArrayList<>();

    static {
        listaProductos.add(new Producto("Arete-manzana",  49.98,  "2022-01-01", "Churrumino", "Tuxtla",        "5B4312T1", 7));
        listaProductos.add(new Producto("Arete-rostro",   109.88, "2022-02-01", "Chililo",    "Tuxtla",        "8F2362G1", 4));
        listaProductos.add(new Producto("Arete-piña",     89.99,  "2022-05-23", "tapia",      "villa flores ", "BO2389D1", 8));
        listaProductos.add(new Producto("Arete-Perla",    98.50,  "2022-03-11", "Churru",     "Tonala",        "B22089G1", 10));
        listaProductos.add(new Producto("Arete-hongo",    120.90, "2022-02-21", "fabricio",   "tapachula",     "HV2089G1", 5));
        listaProductos.add(new Producto("Arete-Mariposa", 50.00,  "2022-07-14", "gael",       "Huixtla",       "VO2389D2", 10));
        listaProductos.add(new Producto("Arete-Moño",     98.50,  "2022-02-21", "ameth",      "Tuxtla",        "8F2342H2", 6));
        listaProductos.add(new Producto("Arete-Corsal",   198.50, "2022-05-01", "sujey",      "villa flores",  "9G2323Z3", 9));
    }

    public static void eliminarProducto(String nombreProducto) {
        Producto producto = obtenerProductoPorNombre(nombreProducto);
        if (producto != null) {
            listaProductos.remove(producto);
        }
    }

    private static Producto obtenerProductoPorNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static List<Producto> getListaProductos() {
        return listaProductos;
    }
}
