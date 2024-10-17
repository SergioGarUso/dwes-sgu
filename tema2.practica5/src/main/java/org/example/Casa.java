package org.example;

import lombok.Getter;
import lombok.Setter;

public class Casa {
    @Getter
    @Setter
    private int id_casa;
    private String nombre_casa;
    private String fundador;
    private String jefe_casa;
    private String fantasma;

    public Casa(int id_casa, String nombre_casa, String fundador, String jefe_casa, String fantasma) {
        this.id_casa = id_casa;
        this.nombre_casa = nombre_casa;
        this.fundador = fundador;
        this.jefe_casa = jefe_casa;
        this.fantasma = fantasma;
    }

    @Override
    public String toString() {
        return "Casa [id_casa=" + id_casa + ", nombre_casa=" + nombre_casa + ", fundador=" + fundador
                + ", jefe_casa=" + jefe_casa + ", fantasma=" + fantasma + "]";
    }
}
