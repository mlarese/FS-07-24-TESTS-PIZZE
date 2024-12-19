package it.epicode.fs0724testspizze.alimenti.pizze;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(3)
public class PizzaAndToppingsRunner implements ApplicationRunner {
    private final PizzaRepository pizzaRepository;
    private final Pizza pizzaMargherita;
    private final Pizza pizzaFunghi;
    private final Pizza pizzaProsciutto;

    @Override
    @Transactional
    // crea un unica transazione per salvare tutte le pizze
    // altrimenti salverebbe solo la prima pizza mentre le altra non verrebbero persistite
    // tuttoi i salvataggi devono avvenire in un unica transazione
    // e @Transactional permette di fare ciò
    public void run(ApplicationArguments args) throws Exception {

            System.out.println("-------- Salvataggio pizze e toppings");
            pizzaRepository.save(pizzaMargherita);
            pizzaRepository.save(pizzaFunghi);
            pizzaRepository.save(pizzaProsciutto);

        List<Pizza>  pizzeByToppingFunghi = pizzaRepository.findByToppingsNomeIgnoreCase("funghi");

        System.out.println("--------******* Pizze con topping funghi");
        pizzeByToppingFunghi.forEach(System.out::println);


    }
}