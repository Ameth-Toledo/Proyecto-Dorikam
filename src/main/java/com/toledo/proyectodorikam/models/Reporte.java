package com.toledo.proyectodorikam.models;

import java.time.LocalDate;

public class Reporte {
    private String titulo;
    private String fecha;
    private String detalles;

    public Reporte(String titulo, String fecha, String detalles) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDetalles() {
        return detalles;
    }
}