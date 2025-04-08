package org.example;

import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Integer legajo, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}