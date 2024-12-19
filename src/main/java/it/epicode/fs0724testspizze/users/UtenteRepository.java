package it.epicode.fs0724testspizze.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    List<Utente> findByNomeAndCognome(String nome, String cognome);

    Utente findByUsername(String username);

    Boolean existsByUsername(String username);

    List<UtentiListResponse> findUtentiListResponseBy();





}