package com.cliet_tableaux.api.paintings.controllers;

import com.cliet_tableaux.api.paintings.dtos.PaintingDto;
import com.cliet_tableaux.api.paintings.services.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {
    @Autowired
    private PaintingService paintingService;

    @GetMapping
    public ResponseEntity<List<PaintingDto>> getPaintings() {
        return new ResponseEntity<>(paintingService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaintingDto> getPainting(@PathVariable Long id) {
        return new ResponseEntity<>(paintingService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaintingDto> createPaintings(@RequestBody PaintingDto paintingDto) {
        return new ResponseEntity<>(paintingService.create(paintingDto),
                HttpStatus.CREATED);
    }
}
