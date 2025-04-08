package org.example;

import java.util.HashSet;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Boolean aprobada() {
        return materias
                .stream()
                .allMatch(materia ->
                        new HashSet<>(alumno.getMateriasAprobadas())
                                .containsAll(materia.getCorrelativas()));
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}