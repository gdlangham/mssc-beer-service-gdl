package dev.gregl.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import dev.gregl.msscbeerservice.domain.Beer;
import dev.gregl.msscbeerservice.repository.BeerRepository;
import dev.gregl.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository repository;

    public BeerLoader(final BeerRepository repository) {
        this.repository = repository;
    }

    private static final String BEER_UPC_1 = "03003002302";
    private static final String BEER_UPC_2 = "03003002304";
    private static final String BEER_UPC_3 = "03003002306";
    @Override
    public void run(final String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (repository.count() == 0) {
            repository.save(Beer.builder().beerName("beer 1").beerStyle(BeerStyleEnum.ALE).quantityToBrew(2).minOnHand(5).upc(BEER_UPC_1).price(
                    BigDecimal.valueOf(10.59)).build());

            repository.save(Beer.builder().beerName("beer 2").beerStyle(BeerStyleEnum.GOSE).quantityToBrew(2).minOnHand(5).upc(BEER_UPC_2).price(
                    BigDecimal.valueOf(10.59)).build());

            repository.save(Beer.builder().beerName("beer 3").beerStyle(BeerStyleEnum.GOSE).quantityToBrew(2).minOnHand(5).upc(BEER_UPC_3).price(
                    BigDecimal.valueOf(10.59)).build());
        }
    }
}
