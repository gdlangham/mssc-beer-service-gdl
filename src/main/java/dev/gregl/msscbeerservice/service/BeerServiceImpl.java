package dev.gregl.msscbeerservice.service;

import java.util.Optional;
import java.util.UUID;

import dev.gregl.msscbeerservice.domain.Beer;
import dev.gregl.msscbeerservice.repository.BeerRepository;
import dev.gregl.msscbeerservice.web.controller.BeerNotFoundException;
import dev.gregl.msscbeerservice.web.mapper.BeerMapper;
import dev.gregl.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(final UUID beerId) throws BeerNotFoundException {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(final BeerDto beerDto) {
        Beer newBeer = beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
        return beerMapper.beerToBeerDto(newBeer);
    }

    @Override
    public BeerDto updateBeer(final UUID beerId, final BeerDto beerDto) throws BeerNotFoundException {
        Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
