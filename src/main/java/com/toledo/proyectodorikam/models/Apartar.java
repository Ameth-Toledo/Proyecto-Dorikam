package com.toledo.proyectodorikam.models;

import java.util.ArrayList;
import java.util.List;

public class Apartar {
    private List<Producto> listaProductos;
    private List<Producto> listaApartados;

    public Apartar() {
        this.listaProductos = Producto.getCopiaListaProductos();
        this.listaApartados = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.remove(producto);
        listaApartados.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        listaApartados.remove(producto);
        listaProductos.add(producto);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Producto> getListaApartados() {
        return listaApartados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Productos Apartados:\n");
        for (Producto producto : listaProductos) {
            sb.append(producto.toString()).append("\n");
        }
        return sb.toString();
    }
}
