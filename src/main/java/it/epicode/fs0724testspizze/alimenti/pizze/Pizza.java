package it.epicode.fs0724testspizze.alimenti.pizze;

import it.epicode.fs0724testspizze.alimenti.Alimento;
import it.epicode.fs0724testspizze.alimenti.topping.Topping;
import it.epicode.fs0724testspizze.menu.IVoceDiMenu;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pizza extends Alimento implements IVoceDiMenu {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    List<Topping> toppings = new ArrayList<>();


    @Override
    public String Descrizione() {

        // inserisce il nome della pizza
        String nome = this.getNome() + " (";

        // inserisce i nomi dei toppings
        // alla fine c'è una virgola in più)
        for (Topping topping : toppings) {
            nome += topping.getNome() + ", ";
        }

        // rimuove l'ultima virgola e concatena  una parentesi chiusa
        return nome.substring(0, nome.length() - 2) + ")";

    }

    @Override
    public String prezzo() {
        return getPrezzo() + "€";
    }

    @Override
    public String calorie() {
        return getCalorie() + " kcal";
    }
}
