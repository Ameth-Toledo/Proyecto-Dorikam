package com.toledo.proyectodorikam.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Imagenes {
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
}
