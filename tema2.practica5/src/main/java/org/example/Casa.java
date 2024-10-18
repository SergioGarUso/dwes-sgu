package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Casa {

    private int id_casa;
    private String nombre_casa;
    private String fundador;
    private String jefe_casa;
    private String fantasma;



    @Override
    public String toString() {
        return "Casa [id_casa=" + id_casa + ", nombre_casa=" + nombre_casa + ", fundador=" + fundador
                + ", jefe_casa=" + jefe_casa + ", fantasma=" + fantasma + "]";
    }
}
