package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.buysourcecode.util.DateTimeUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User createBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "review", cascade = CascadeType.ALL)
    private List<AssetReview> imgDescription = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        this.createdAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.setStatus(ReviewStatus.CREATED);
    }

    @PreUpdate
    private void preUpdate() {
        this.setStatus(ReviewStatus.UPDATED);
    }

}
