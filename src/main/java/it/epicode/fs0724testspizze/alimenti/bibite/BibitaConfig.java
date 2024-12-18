package it.epicode.fs0724testspizze.alimenti.bibite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BibitaConfig {

    @Bean(name = "bibitaAranciata")
    public Bibita aranciata() {
        Bibita a = new Bibita();
        a.setNome("Aranciata");
        a.setCalorie(100);
        a.setPrezzo(2.0);
        a.setQuantita(0.5);
        return a;
    }

    @Bean(name = "bibitaCocaCola")
    public Bibita cocaCola() {
        Bibita c = new Bibita();
        c.setNome("Coca Cola");
        c.setCalorie(150);
        c.setPrezzo(2.5);
        c.setQuantita(0.5);
        return c;
    }

    @Bean(name = "bibitaBirra")
    public Bibita birra() {
        Bibita b = new Bibita();
        b.setNome("Birra");
        b.setCalorie(200);
        b.setPrezzo(3.0);
        b.setQuantita(0.5);
        b.setPercentualeAlcolica(5.0);
        return b;
    }

    @Bean(name = "bibitaAcqua")
    public Bibita acqua() {
        Bibita a = new Bibita();
        a.setNome("Acqua");
        a.setCalorie(0);
        a.setPrezzo(1.0);
        a.setQuantita(0.5);
        return a;
    }
}
