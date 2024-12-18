package it.epicode.fs0724testspizze.menu;

import it.epicode.fs0724testspizze.alimenti.bibite.Bibita;
import it.epicode.fs0724testspizze.alimenti.bibite.BibitaRepository;
import it.epicode.fs0724testspizze.alimenti.pizze.Pizza;
import it.epicode.fs0724testspizze.alimenti.pizze.PizzaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(10)
public class MenuRunnerRunner implements ApplicationRunner {
    private final MenuService menuService;

    @Override

    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Menu m = menuService.createAndSAveMenu();
        m.stampaMenu();

    }
}