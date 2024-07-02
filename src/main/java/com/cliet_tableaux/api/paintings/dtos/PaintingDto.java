package com.cliet_tableaux.api.paintings.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaintingDto {
    private long id;
    private String title;
    private String description;
    private boolean sell = false;
    private String pictureUrl;
    private Long priceInCents;
    private LocalDateTime createdAd;
    private LocalDateTime updatedAt;
}
