package com.cliet_tableaux.api.paintings.entities;

import com.cliet_tableaux.api.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paintings")
public class PaintingEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "sell")
    private boolean sell = false;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "price_cents")
    private Long priceInCents;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAd;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "paintings")
    List<UserEntity> users;

}
