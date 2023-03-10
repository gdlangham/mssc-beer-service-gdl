package dev.gregl.msscbeerservice.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import dev.gregl.msscbeerservice.service.BeerService;
import dev.gregl.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("${app.v1.beer.base-url}")
@RestController
public class BeerController {

    @Value("${app.v1.beer.base-url}")
    private String baseUrl;

    private final BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) throws BeerNotFoundException {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto)
            throws BeerNotFoundException {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
//        beerService.deleteById(beerId);
    }
}