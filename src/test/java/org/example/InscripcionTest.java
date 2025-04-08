package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    public void inscripcionAprobadaSinCorrelativas() {
        Materia algebra = new Materia("Álgebra", 1, Collections.emptyList());

        Alumno alumno = new Alumno("Sofía", "González", 1234, List.of());
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(algebra));

        assertTrue(inscripcion.aprobada(), "El alumno debería poder inscribirse a una materia sin correlativas");
    }

    @Test
    public void inscripcionAprobadaConCorrelativasCumplidas() {
        Materia algoritmos = new Materia("Algoritmos", 2, List.of());
        Materia paradigmas = new Materia("Paradigmas", 3, List.of(algoritmos));

        Alumno alumno = new Alumno("Carlos", "Pérez", 2345, List.of(algoritmos));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));

        assertTrue(inscripcion.aprobada(), "El alumno cumple con la correlativa y debería poder inscribirse");
    }

    @Test
    public void inscripcionRechazadaPorFaltaDeCorrelativas() {
        Materia algoritmos = new Materia("Algoritmos", 2, List.of());
        Materia paradigmas = new Materia("Paradigmas", 3, List.of(algoritmos));

        Alumno alumno = new Alumno("María", "López", 3456, List.of()); // No aprobó "Algoritmos"
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));

        assertFalse(inscripcion.aprobada(), "El alumno no cumple con la correlativa y no debería poder inscribirse");
    }

    @Test
    public void inscripcionConVariasMateriasTodasAprobadas() {
        Materia am1 = new Materia("AM1", 11, List.of());
        Materia algebra = new Materia("Álgebra", 1, Collections.emptyList());
        Materia am2 = new Materia("AM2", 2, List.of(am1, algebra));
        Materia matSup = new Materia("Matemática Superior", 3, List.of(am2));

        Alumno alumno = new Alumno("Lucía", "Ramírez", 4567, List.of(am1, am2, algebra));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(matSup));

        assertTrue(inscripcion.aprobada(), "El alumno tiene aprobadas todas las correlativas necesarias");
    }

    @Test
    public void inscripcionConUnaMateriaQueNoCumpleYOtraQueSi() {
        Materia arquitectura = new Materia("Arquitectura de Computadoras", 1, List.of());
        Materia algoritmos = new Materia("Algoritmos", 2, List.of());
        Materia so = new Materia("Sistemas Operativos", 3, List.of(arquitectura));

        Alumno alumno = new Alumno("Juan", "Martínez", 5678, List.of(algoritmos)); // Tiene solo "Algoritmos" aprobada
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(so, arquitectura)); // "Sistemas Operativos requiere Arquitectura que no tiene

        assertFalse(inscripcion.aprobada(), "Una materia no cumple, así que toda la inscripción debe ser rechazada");
    }
}