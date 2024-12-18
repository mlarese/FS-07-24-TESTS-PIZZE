package it.epicode.fs0724testspizze.alimenti.topping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

    @Bean(name = "toppingPomodoro")
    public Topping pomodoro() {
        Topping p = new Topping();
        p.setNome("Pomodoro");
        p.setCalorie(50);
        p.setPrezzo(1.0);
        return p;
    }

    @Bean(name = "toppingMozzarella")
    public Topping mozzarella() {
        Topping m = new Topping();
        m.setNome("Mozzarella");
        m.setCalorie(100);
        m.setPrezzo(2.0);
        return m;
    }

    @Bean(name = "toppingFunghi")
    public Topping funghi() {
        Topping f = new Topping();
        f.setNome("Funghi");
        f.setCalorie(30);
        f.setPrezzo(1.5);
        return f;
    }

    @Bean(name = "toppingProsciutto")
    public Topping prosciutto() {
        Topping p = new Topping();
        p.setNome("Prosciutto");
        p.setCalorie(70);
        p.setPrezzo(2.5);
        return p;
    }
}
