package it.epicode.fs0724testspizze.menu;


import it.epicode.fs0724testspizze.alimenti.bibite.Bibita;
import it.epicode.fs0724testspizze.alimenti.bibite.BibitaRepository;
import it.epicode.fs0724testspizze.alimenti.pizze.Pizza;
import it.epicode.fs0724testspizze.alimenti.pizze.PizzaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final PizzaRepository pizzaRepository;
    private final BibitaRepository bibitaRepository;
    private final Menu menuPranzo;
    private final MenuRepository menuRepository;

    @Transactional
    public Menu createAndSAveMenu() {
        List<Pizza> pizze = pizzaRepository.findAll();
        List<Bibita> bibite = bibitaRepository.findAll();

        menuPranzo.setPizze(pizze);
        menuPranzo.setBibite(bibite);

        menuRepository.save(menuPranzo);

        return menuPranzo;

    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);

    }

    public Integer countMenu() {
        return (int) menuRepository.count();
    }

    public Menu findMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

}