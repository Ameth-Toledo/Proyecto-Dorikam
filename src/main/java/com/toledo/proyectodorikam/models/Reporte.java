package com.toledo.proyectodorikam.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private final StringProperty titulo;
    private final StringProperty fechaReporte;
    private final StringProperty detallesReporte;
    private static List<Reporte> listaReporte = new ArrayList<>();

    public Reporte(String titulo, String fechaReporte, String detallesReporte) {
        this.titulo = new SimpleStringProperty(titulo);
        this.fechaReporte = new SimpleStringProperty(fechaReporte);
        this.detallesReporte = new SimpleStringProperty(detallesReporte);
    }

    public static void generarReporte(Reporte reporte) {
        listaReporte.add(reporte);
    }

    public static List<Reporte> getListaReporte() {
        return listaReporte;
    }

    public String getTitulo() {
        return titulo.get();
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public String getFechaReporte() {
        return fechaReporte.get();
    }

    public StringProperty fechaReporteProperty() {
        return fechaReporte;
    }

    public String getDetalles() {
        return detallesReporte.get();
    }

    public StringProperty detallesProperty() {
        return detallesReporte;
    }
}
