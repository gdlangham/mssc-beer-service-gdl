package dev.gregl.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import dev.gregl.msscbeerservice.domain.Beer;
import dev.gregl.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository repository;

    public BeerLoader(final BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(final String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (repository.count() == 0) {
            repository.save(Beer.builder().beerName("beer 1").beerStyle("silly").quantityToBrew(2).minOnHand(5).upc(30030L).price(
                    BigDecimal.valueOf(10.59)).build());

            repository.save(Beer.builder().beerName("beer 2").beerStyle("wacky").quantityToBrew(2).minOnHand(5).upc(30031L).price(
                    BigDecimal.valueOf(10.59)).build());
        }
    }
}
