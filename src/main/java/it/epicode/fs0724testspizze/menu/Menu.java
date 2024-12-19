package it.epicode.fs0724testspizze.menu;

import it.epicode.fs0724testspizze.alimenti.bibite.Bibita;
import it.epicode.fs0724testspizze.alimenti.pizze.Pizza;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String descrizione;

    private LocalDate dataDiCreazione;
    @OneToMany
    private List<Pizza> pizze;

    @OneToMany
    private List<Bibita>  bibite;

    public void stampaMenu() {
        System.out.println("Menu: " + this.nome);
        System.out.println("Pizze:");
        for (Pizza pizza : pizze) {
            System.out.println(pizza.Descrizione() + " " + pizza.prezzo() + " " + pizza.calorie());
        }
        System.out.println("Bibite:");
        for (Bibita bibita : bibite) {
            System.out.println(bibita.Descrizione() + " " + bibita.prezzo() + " " + bibita.calorie());
        }
    }

}
