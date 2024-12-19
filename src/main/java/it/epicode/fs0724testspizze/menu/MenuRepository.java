package it.epicode.fs0724testspizze.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {


    // cerca un menu per nome e mette in ordine alfabetico per nome stesso
    List<Menu> findByNomeOrderByNome(String nome);


    // cerca un menu per nome e descrizione
    List<Menu> findByNomeAndDescrizione(String nome, String descrizione);


    // cerca tutti i menu che sono stati creati inn un intervallo di date
    List<Menu> findByDataDiCreazioneBetweenOrderByDataDiCreazioneAsc(LocalDate data1, LocalDate data2);




}