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
public class Asignatura {

    private int id_asignatura;
    private String nombre_asignatura;
    private String aula;
    private boolean obligatoria;




    @Override
    public String toString() {
        return "Asignatura [id_asignatura=" + id_asignatura + ", nombre_asignatura=" + nombre_asignatura
                + ", aula=" + aula + ", obligatoria=" + obligatoria + "]\n";
    }
}
