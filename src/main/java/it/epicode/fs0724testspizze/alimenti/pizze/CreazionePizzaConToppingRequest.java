package it.epicode.fs0724testspizze.alimenti.pizze;

import lombok.Data;

import java.util.List;

@Data
public class CreazionePizzaConToppingRequest {
    private String nome;
    private List<Long> toppingsId;
}
