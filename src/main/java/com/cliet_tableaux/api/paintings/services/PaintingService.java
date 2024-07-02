package com.cliet_tableaux.api.paintings.services;

import com.cliet_tableaux.api.paintings.dtos.PaintingDto;
import com.cliet_tableaux.api.paintings.entities.PaintingEntity;
import com.cliet_tableaux.api.paintings.mappers.PaintingMapper;
import com.cliet_tableaux.api.paintings.repositories.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingService {
    @Autowired
    private PaintingRepository paintingRepository;

    @Autowired
    private PaintingMapper paintingMapper;

    public List<PaintingDto> findAll() {
        return paintingMapper.listEntityToListDto(paintingRepository.findAll());
    }

    public PaintingDto create(PaintingDto newPainting) {
        PaintingEntity savedPainting =
                paintingRepository.save(paintingMapper.paintingDtoToEntity(newPainting));
        return paintingMapper.paintingEntityToDto(savedPainting);
    }

    public PaintingDto find(Long paintingId) {
        PaintingEntity retrievedPainting =
                paintingRepository.findById(paintingId).orElseThrow();

        return paintingMapper.paintingEntityToDto(retrievedPainting);
    }
}
