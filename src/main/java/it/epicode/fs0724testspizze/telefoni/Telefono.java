package it.epicode.fs0724testspizze.telefoni;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "telefono")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numero;
    private String tipo;

}
