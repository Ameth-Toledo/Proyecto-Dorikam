package com.toledo.proyectodorikam.models;

import java.util.ArrayList;

public class Administrador {
    private ArrayList<Producto> listaProductos;

    public Administrador() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

}