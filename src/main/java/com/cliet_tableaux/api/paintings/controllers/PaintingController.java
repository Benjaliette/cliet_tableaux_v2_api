package com.cliet_tableaux.api.paintings.controllers;

import com.cliet_tableaux.api.paintings.dtos.PaintingDto;
import com.cliet_tableaux.api.paintings.services.PaintingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
@Tag(name = "Paintings API")
public class PaintingController {
    @Autowired
    private PaintingService paintingService;

    @Operation(
            summary = "Get all paintings",
            description = "Returns all paintings"
    )
    @GetMapping
    public ResponseEntity<List<PaintingDto>> getPaintings() {
        return new ResponseEntity<>(paintingService.findAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get a painting by id",
            description = "Returns a painting as per the id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PaintingDto> getPainting(@PathVariable Long id) {
        return new ResponseEntity<>(paintingService.find(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Create a new painting",
            description = "Returns the newly created painting"
    )
    @PostMapping
    public ResponseEntity<PaintingDto> createPaintings(@RequestBody PaintingDto paintingDto) {
        return new ResponseEntity<>(paintingService.create(paintingDto),
                HttpStatus.CREATED);
    }
}
