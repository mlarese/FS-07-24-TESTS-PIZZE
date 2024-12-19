package it.epicode.fs0724testspizze.users;

import it.epicode.fs0724testspizze.telefoni.Telefono;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String citta;
    private String indirizzo;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Telefono> telefoni = new ArrayList<>();

}
