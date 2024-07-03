package com.cliet_tableaux.api.orders.entities;

import com.cliet_tableaux.api.paintings.entities.PaintingEntity;
import com.cliet_tableaux.api.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "state", nullable = false)
    private String state = "A vendre";

    @Column(name = "amount_cents", nullable = false)
    private Long amountCents;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAd;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
/*
    @ManyToOne
    @JoinColumn(name = "painting_id")
    private PaintingEntity painting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;*/
}
