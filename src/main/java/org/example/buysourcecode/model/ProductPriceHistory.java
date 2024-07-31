package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product_price_histories")
public class ProductPriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Double price;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="ended_at", nullable = false)
    private Long endedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_by_user", nullable = false)
    private User user;

}
