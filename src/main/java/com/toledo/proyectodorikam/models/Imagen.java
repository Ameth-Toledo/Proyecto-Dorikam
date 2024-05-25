package com.toledo.proyectodorikam.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Imagen {
    private static List<File> listaZapatos = new ArrayList<>();
    private static List<File> listaAretes = new ArrayList<>();

    public static void agregarImagen(File imagen, String opcion) {
        switch (opcion) {
            case "Zapato":
                listaZapatos.add(imagen);
                break;
            case "Arete":
                listaAretes.add(imagen);
                break;
            default:
                break;
        }
    }

    public static List<File> getListaZapatos() {
        return listaZapatos;
    }

    public static List<File> getListaAretes() {
        return listaAretes;
    }

    public static void eliminarImagen(String imagenUrl, String opcion) {
        List<File> lista = null;
        switch (opcion) {
            case "Zapato":
                lista = listaZapatos;
                break;
            case "Arete":
                lista = listaAretes;
                break;
            default:
                break;
        }

        if (lista != null) {
            lista.removeIf(file -> file.toURI().toString().equals(imagenUrl));
        }
    }
}
