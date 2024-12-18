package it.epicode.fs0724testspizze.alimenti.pizze;


import it.epicode.fs0724testspizze.alimenti.topping.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PizzaConfig {
    private final Topping toppingPomodoro;
    private final Topping toppingMozzarella;
    private final Topping toppingFunghi;
    private final Topping toppingProsciutto;


    @Bean(name = "pizzaMargherita")
    public Pizza margherita() {
        Pizza margherita = new Pizza();
        margherita.setNome("Margherita");
        margherita.setPrezzo(5.0);
        margherita.setCalorie(500);
        margherita.getToppings().add(toppingPomodoro);
        margherita.getToppings().add(toppingMozzarella);
        return margherita;
    }

    @Bean(name = "pizzaFunghi")
    public Pizza funghi() {
        Pizza funghi = new Pizza();
        funghi.setNome("Funghi");
        funghi.setPrezzo(6.0);
        funghi.setCalorie(600);
        funghi.getToppings().add(toppingPomodoro);
        funghi.getToppings().add(toppingMozzarella);
        funghi.getToppings().add(toppingFunghi);
        return funghi;
    }

    @Bean(name = "pizzaProsciutto")
    public Pizza prosciutto() {
        Pizza prosciutto = new Pizza();
        prosciutto.setNome("Prosciutto");
        prosciutto.setPrezzo(7.0);
        prosciutto.setCalorie(700);
        prosciutto.getToppings().add(toppingPomodoro);
        prosciutto.getToppings().add(toppingMozzarella);
        prosciutto.getToppings().add(toppingProsciutto);
        return prosciutto;
    }


}
