package it.epicode.fs0724testspizze.telefoni;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
    Telefono findByNumero(String numero);

}