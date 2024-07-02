package com.cliet_tableaux.api.paintings.controllers;

import com.cliet_tableaux.api.paintings.dtos.PaintingDto;
import com.cliet_tableaux.api.paintings.services.PaintingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PaintingController.class)
public class PaintingControllerTest {
    private PaintingDto painting1;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @MockBean
    PaintingService paintingService;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

        painting1 =
                PaintingDto.builder()
                        .id(1L)
                        .title("Painting test")
                        .description("Description test")
                        .priceInCents(1000L).build();

    }

    @Test
    void testGetAllPaintings() throws Exception {
        List<PaintingDto> paintingList = new ArrayList<>();

        paintingList.add(painting1);

        when(paintingService.findAll()).thenReturn(paintingList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/paintings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("[0].title",
                        Matchers.equalTo("Painting test")));
    }

    @Test
    void testGetPainting() throws Exception {
        when(paintingService.find(ArgumentMatchers.any())).thenReturn(painting1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/paintings/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.title", Matchers.equalTo("Painting " +
                        "test")));
    }

    @Test
    void testCreateHome() throws Exception {
        when(paintingService.create(ArgumentMatchers.any())).thenReturn(painting1);

        String json =
                mapper.registerModule(new JavaTimeModule()).writeValueAsString(painting1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/paintings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.title",
                        Matchers.equalTo("Painting test")));
    }
}
