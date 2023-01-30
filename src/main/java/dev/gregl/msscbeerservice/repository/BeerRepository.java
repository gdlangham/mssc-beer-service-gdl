package dev.gregl.msscbeerservice.repository;

import java.util.UUID;

import dev.gregl.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
