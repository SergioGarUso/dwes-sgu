package org.example.tareasweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import org.example.tareasweb.entities.Tarea;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToMany
    @JoinTable(
            name = "trabajador_tarea",
            joinColumns = @JoinColumn(name = "trabajador_id"),
            inverseJoinColumns = @JoinColumn(name = "tarea_id")
    )
    private Set<Tarea> tareas = new HashSet<>();

}
