package it.epicode.fs0724testspizze.users;


import it.epicode.fs0724testspizze.telefoni.Telefono;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public Utente findByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    public List<UtentiListResponse> findAll() {

        // query su db, la query restituisce gli entity, uso una mapping per copiare i miei entity in un dto
        // query su db dove estraggo solo quey campi e te li metto nel risultato richiaeso

        return utenteRepository.findUtentiListResponseBy();
    }
    public void registraUtente(RegistraUtenteRequest request) {
        // controllo che utente non esista già
        if(utenteRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Utente già esistente con username " + request.getUsername());
        }

        Utente utente = new Utente();
        utente.setUsername(request.getUsername());
        utente.setNome(request.getNome());
        utente.setCognome(request.getCognome());
        utente.setEmail(request.getEmail());
        utente.setPassword(request.getPassword());
        utente.setIndirizzo(request.getIndirizzo());
        utente.setCitta(request.getCitta());

        if(request.getCellulare() != null) {
            Telefono cellulare = new Telefono();
            cellulare.setNumero(request.getCellulare());
            cellulare.setTipo("cellulare");
            utente.getTelefoni().add(cellulare);
        }

        if(request.getTelCasa() != null) {
            Telefono telCasa = new Telefono();
            telCasa.setNumero(request.getTelCasa());
            telCasa.setTipo("casa");
            utente.getTelefoni().add(telCasa);
        }

        if(request.getLavoro() != null) {
            Telefono lavoro = new Telefono();
            lavoro.setNumero(request.getLavoro());
            lavoro.setTipo("lavoro");
            utente.getTelefoni().add(lavoro);
        }

        utenteRepository.save(utente);
    }

}