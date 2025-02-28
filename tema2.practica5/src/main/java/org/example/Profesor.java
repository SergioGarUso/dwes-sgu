package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    private int id_profesor;
    private String nombre;
    private String apellido;
    private int id_asignatura;
    private LocalDate fecha_inicio;



    @Override
    public String toString() {
        return "Profesor [id_profesor=" + id_profesor + ", nombre=" + nombre + ", apellido=" + apellido
                + ", id_asignatura=" + id_asignatura + ", fecha_inicio=" + fecha_inicio + "]";
    }
}
