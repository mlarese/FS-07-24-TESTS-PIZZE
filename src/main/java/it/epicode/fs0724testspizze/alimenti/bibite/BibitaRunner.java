package it.epicode.fs0724testspizze.alimenti.bibite;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class BibitaRunner implements ApplicationRunner {
    private final Bibita bibitaAcqua;
    private final Bibita bibitaCocaCola;
    private final Bibita bibitaAranciata;
    private final Bibita bibitaBirra;
    private final BibitaRepository bibitaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("-------- Salvataggio bibite");
        bibitaRepository.save(bibitaAcqua);
        bibitaRepository.save(bibitaCocaCola);
        bibitaRepository.save(bibitaAranciata);
        bibitaRepository.save(bibitaBirra);


    }
}