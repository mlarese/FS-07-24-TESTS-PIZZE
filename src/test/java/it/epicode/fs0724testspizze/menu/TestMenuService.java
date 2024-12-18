package it.epicode.fs0724testspizze.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestMenuService {
    @Autowired
    private MenuService menuService;

    @Test
    // salta il test, serve ad escludere momentaneamente un test
    //@Disabled
    @DisplayName("Test per il salvataggio di un menu")
    public void testSaveMenu() {
        Integer menuGiaSalvati = menuService.countMenu();
        Menu menu = new Menu();
        menu.setNome("Menu di test");
        menu=menuService.saveMenu(menu);

        Integer menuSalvati = menuService.countMenu();

        assertEquals(menuGiaSalvati + 1, menuSalvati);

        Menu menuCaricato = menuService.findMenuById(menu.getId());
        assertEquals(menu.getNome(), menuCaricato.getNome());

    }

    // il test è parametrico per cui il metodo accetta parametri
    @ParameterizedTest
    @DisplayName("Test parametrico di creazione di tre menu")

    // se il parametro è singolo uso @ValueSource che contiene un array di parametri
    // il test verrà eseguito tante volte quanti sono i parametri
    @ValueSource(strings = {"Menu pranzo", "Menu cena", "colazione"})

    public void testParametrico(String nomeMenu) {
        // nomeMenu al primo giro vale "Menu pranzo"
        // nomeMenu al secondo giro vale "Menu cena"
        // nomeMenu al terzo giro vale "colazione"

        Integer menuGiaSalvati = menuService.countMenu();
        Menu menu = new Menu();
        menu.setNome(nomeMenu);
        menu=menuService.saveMenu(menu);

        Integer menuSalvati = menuService.countMenu();

        assertEquals(menuGiaSalvati + 1, menuSalvati);

        Menu menuCaricato = menuService.findMenuById(menu.getId());
        assertEquals(menu.getNome(), menuCaricato.getNome());
    }

    // il test è parametrico per cui il metodo accetta parametri
    @ParameterizedTest
    @DisplayName("Test parametrico di creazione di tre menu con tre diverse descrizioni")
    // se i parametri sono più di uno uso @CsvSource
    // esso contiene tante stringhe in cui i valori sono separati da virgola
    // ad esempio se la stringa è "Menu pranzo, menu per il pranzo"
    // il primo valore è "Menu pranzo" e il secondo valore è "menu per il pranzo"

    @CsvSource({"Menu pranzo, menu per il pranzo", "Menu cena, menu per la cena", "colazione, menu per la colazione"})
    public void testParametrico(String nomeMenu, String descrizioneMenu) {
        Integer menuGiaSalvati = menuService.countMenu();
        Menu menu = new Menu();
        menu.setNome(nomeMenu);
        menu.setDescrizione("il tuo menu si chiama" + descrizioneMenu);
        menu=menuService.saveMenu(menu);

        Integer menuSalvati = menuService.countMenu();

        assertEquals(menuGiaSalvati + 1, menuSalvati);

        Menu menuCaricato = menuService.findMenuById(menu.getId());
        assertEquals(menu.getNome(), menuCaricato.getNome());
    }

}
