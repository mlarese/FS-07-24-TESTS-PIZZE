package it.epicode.fs0724testspizze.alimenti.pizze;


import it.epicode.fs0724testspizze.alimenti.topping.Topping;
import it.epicode.fs0724testspizze.alimenti.topping.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final ToppingRepository toppingRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public void savePizzaAndToppings(CreazionePizzaConToppingRequest request) {

        for (Long toppingId : request.getToppingsId()) {
            if(!toppingRepository.existsById(toppingId)) {
                throw new IllegalArgumentException("Topping non esistente con id " + toppingId);
            }

        }

        Pizza pizza = new Pizza();
        pizza.setNome(request.getNome());

        for (Long toppingId : request.getToppingsId()) {
            Topping currentTopping = toppingRepository.findById(toppingId).get();
            pizza.getToppings().add(currentTopping);
        }

        pizzaRepository.save(pizza);



    }

}