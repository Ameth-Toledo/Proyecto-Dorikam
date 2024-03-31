package com.toledo.proyectodorikam.models;


import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private final String titulo;
    private final String fechaReporte;
    private final String detalles;
    private static List<Reporte> listaReporte = new ArrayList<>();

    public Reporte(String titulo, String fechaReporte, String detalles) {
        this.titulo = titulo;
        this.fechaReporte = fechaReporte;
        this.detalles = detalles;
    }
    public static void generarReporte (Reporte reporte){
        listaReporte.add(reporte);
    }

    public static List<Reporte> getListaReporte() {
        return listaReporte;
    }

    public static void setListaReporte(List<Reporte> listaReporte) {
        Reporte.listaReporte = listaReporte;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public String getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Reporte: " +
                "Titulo: " + titulo + '\'' +
                ", Fecha del Reporte: " + fechaReporte + '\'' +
                ", Detalles: " + detalles + '\'';
    }
}
