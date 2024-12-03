package org.example.tareasweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.tareasweb.entities.Trabajador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_apertura", nullable = false)
    private LocalDate fechaApertura;

    @Column(name = "fecha_planificada_cierre", nullable = false)
    private LocalDate fechaPlanificadaCierre;

    @Column(name = "tipo", nullable = false)
    private String tipo; // Puede tomar valores "MEJORA", "BUG", "REFACTORIZACION"

    @Column(name = "estado", nullable = false)
    private String estado; // Puede tomar valores "ABIERTA", "EN_PROGRESO", "CERRADA"

    @ManyToMany(mappedBy = "tareas")
    private Set<Trabajador> trabajadores = new HashSet<>();

}
