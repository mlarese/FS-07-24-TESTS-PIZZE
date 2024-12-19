package it.epicode.fs0724testspizze.alimenti.pizze;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    // cerca le con calorie maggiori di un certo valore e le mette in ordine crescnte per nome
    List<Pizza> findByCalorieGreaterThanOrderByNome(int calorie);

    // cerca le con calorie maggiori di un certo valore e le mette in ordine decrescnte per nome
    List<Pizza> findByCalorieGreaterThanOrderByNomeDesc(int calorie);

    // si può restituire un solo elemento specificando nel Tipo di ritorno la classe  e no List
    Pizza findByNome(String nome);

    // cerca le pizze con le calorie comprese tra due valori
    List<Pizza> findByCalorieBetweenOrderByCalorie(int min, int max);

    // cerco le pizze che contengano la stringa 'marg' nel nome
    List<Pizza> findByNomeContaining(String nome);

    // cerco le pizze che contengano la stringa 'marg' nel nome senza tenere conto di maiuscole e minuscole
    List<Pizza> findByNomeContainingIgnoreCase(String nome);


    // cerca tutte le pizze che contengono un topping di un certo nome
    List<Pizza> findByToppingsNomeIgnoreCase(String nome);


    @Query("SELECT p FROM Pizza p WHERE p.nome = :nome")
    List<Pizza> trovaLePizzePerNome(String nome);
    //


}