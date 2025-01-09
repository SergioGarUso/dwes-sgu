package org.example.completeapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// TODO: Ejercicio 1
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "physical_books")
public class PhysicalBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicamos que el valor de la clave primaria se generará automáticamente
    private Long id;

    @Column(name = "state")
    private String state;

    @Column(name = "aqcuired_date")
    private LocalDate aqcuiredDate;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
