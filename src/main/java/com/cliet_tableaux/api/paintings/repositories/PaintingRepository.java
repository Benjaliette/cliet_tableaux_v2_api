package com.cliet_tableaux.api.paintings.repositories;

import com.cliet_tableaux.api.paintings.entities.PaintingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<PaintingEntity, Long> {
    @Override
    List<PaintingEntity> findAll();

    @Override
    PaintingEntity save(PaintingEntity paintingEntity);
}
