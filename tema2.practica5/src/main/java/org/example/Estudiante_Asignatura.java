package org.example;

public class Estudiante_Asignatura {
    private int id_estudiante;
    private int id_asignatura;
    private float calificacion;

    public Estudiante_Asignatura(int id_estudiante, int id_asignatura, float calificacion) {
        this.id_estudiante = id_estudiante;
        this.id_asignatura = id_asignatura;
        this.calificacion = calificacion;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Estudiante_Asignatura{" +
                "id_estudiante=" + id_estudiante +
                ", id_asignatura=" + id_asignatura +
                ", calificacion=" + calificacion +
                '}';
    }
}
