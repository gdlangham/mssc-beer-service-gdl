package dev.gregl.msscbeerservice.web.mapper;

import dev.gregl.msscbeerservice.domain.Beer;
import dev.gregl.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses=DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
