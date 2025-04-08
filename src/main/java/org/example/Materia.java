package org.example;

import java.util.List;

public class Materia {
    private String nombre;
    private Integer codigo;
    private List<Materia> correlativas;

    public Materia(String nombre, Integer codigo, List<Materia> correlativas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.correlativas = correlativas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}