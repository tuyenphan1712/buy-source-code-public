package org.example.buysourcecode.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.*;
import org.example.buysourcecode.util.DateTimeUtil;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    @Expose
    private String id;

    @Column(nullable = false, length = 20)
    @Expose
    private String name;

    @Column(length = 20)
    private String keyword;

    @Column(nullable = false, unique = true)
    @Expose
    private String slug;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Expose
    private String description;

    @Column(nullable = false)
    @Expose
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by", nullable = false)
    private User createBy;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private List<AssetProduct> assetProductList;

    @PrePersist
    public void prePersist() {
        this.createdAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.setStatus(ProductStatus.CREATED);
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
    }

}
