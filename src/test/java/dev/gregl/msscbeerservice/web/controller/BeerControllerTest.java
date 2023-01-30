package dev.gregl.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.gregl.msscbeerservice.web.model.BeerDto;
import dev.gregl.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("valid beer")
                .upc(1L)
                .beerStyle(BeerStyleEnum.ALE)
                .price(BigDecimal.valueOf(8.99))
                .build();
    }

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        UUID newId = UUID.randomUUID();
        BeerDto savedDto = BeerDto.builder().id(newId).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

//        given(beerService.saveNewBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = validBeer;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + validBeer.getId().toString())
                        .content(beerDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

//        then(beerService).should().updateBeer(any(UUID.class), any());
    }

    @Test
    void deleteBeer() {
    }
}