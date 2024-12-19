package it.epicode.fs0724testspizze;


import it.epicode.fs0724testspizze.users.RegistraUtenteRequest;
import it.epicode.fs0724testspizze.users.Utente;
import it.epicode.fs0724testspizze.users.UtenteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestUtenteService {

    @Autowired
    private UtenteService utenteService;

    @Test
    @DisplayName("Test registrazione utente tramite Dto di richiesta")
    public void testRegistraUtente() {
        RegistraUtenteRequest request = new RegistraUtenteRequest();
        request.setUsername("mlarese");
        request.setPassword("xxxxxxx");
        request.setNome("Mario");
        request.setCognome("Larese");
        request.setEmail("mf@gmail.com");
        request.setIndirizzo("Via Roma 1");
        request.setCitta("Roma");
        request.setCellulare("3333333333");
        request.setTelCasa("0666666666");
        request.setLavoro("0777777777");


        utenteService.registraUtente(request);

        Utente utente = utenteService.findByUsername("mlarese");

        assertNotNull(utente);
        assertEquals("mlarese", utente.getUsername());
        assertEquals("Mario", utente.getNome());
        assertEquals("Larese", utente.getCognome());
        assertEquals("mf@gmail.com", utente.getEmail());


    }

}
