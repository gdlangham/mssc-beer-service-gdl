package dev.gregl.msscbeerservice.service;

import java.util.UUID;

import dev.gregl.msscbeerservice.domain.Beer;
import dev.gregl.msscbeerservice.web.controller.BeerNotFoundException;
import dev.gregl.msscbeerservice.web.model.BeerDto;

public interface BeerService {
    BeerDto getById(UUID beerId) throws BeerNotFoundException;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws BeerNotFoundException;
}
