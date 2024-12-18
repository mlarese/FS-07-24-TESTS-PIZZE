package it.epicode.fs0724testspizze.alimenti.bibite;

import it.epicode.fs0724testspizze.alimenti.Alimento;
import it.epicode.fs0724testspizze.menu.IVoceDiMenu;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bibita extends Alimento implements IVoceDiMenu {

    private Double quantita;
    private Double percentualeAlcolica=0.0;

    @Override
    public String Descrizione() {
        if(this.percentualeAlcolica==0)
            return this.getNome() +  " (" + this.getQuantita() + "ml)";
        else
            return this.getNome() +  " (" + this.getQuantita() + "ml, " + this.percentualeAlcolica + "%)";
    }

    @Override
    public String prezzo() {
        return this.getPrezzo() + "€";
    }

    @Override
    public String calorie() {
        return this.getCalorie() + " kcal";
    }
}
