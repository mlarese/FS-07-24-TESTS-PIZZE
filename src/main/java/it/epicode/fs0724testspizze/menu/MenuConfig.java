package it.epicode.fs0724testspizze.menu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {
    @Bean(name = "menuPranzo")
    public Menu menuPranzo() {
        Menu m = new Menu();
        m.setNome("Menu Pranzo");
        return m;
    }
}
