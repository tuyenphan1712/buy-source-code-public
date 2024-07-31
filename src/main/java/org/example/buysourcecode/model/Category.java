package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 255, nullable = false)
    private String slug;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.status = Status.CREATED;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

}
