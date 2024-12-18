package it.epicode.fs0724testspizze.alimenti;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alimenti")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private double prezzo;
    private Integer calorie;

}
