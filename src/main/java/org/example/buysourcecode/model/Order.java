package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.buysourcecode.util.DateTimeUtil;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User customer;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @PrePersist
    public void prePersist() {
        this.createdAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.setStatus(OrderStatus.PENDING);
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
    }
}
