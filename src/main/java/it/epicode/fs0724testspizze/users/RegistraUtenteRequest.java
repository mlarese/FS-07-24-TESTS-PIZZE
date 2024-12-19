package it.epicode.fs0724testspizze.users;

import lombok.Data;

@Data
public class RegistraUtenteRequest {
    // username, password, nome, cognome, indirizzo, email , telCasa, cellulare, lavoro
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String citta;
    private String email;
    private String telCasa;
    private String cellulare;
    private String lavoro;

}
