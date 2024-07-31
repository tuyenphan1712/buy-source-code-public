package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.buysourcecode.util.DateTimeUtil;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 255)
    private String path;

    @Column(nullable = false, length = 128)
    private String type;

    @Column(nullable = false)
    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by", nullable = false)
    private User createBy;

    @Column(name ="created_at", nullable = false)
    private Long createdAt;

    @Column(name ="updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    protected void onCreate() {
        this.createdAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.updatedAt =  DateTimeUtil.toEpochSecond(LocalDateTime.now());
        this.setStatus(Status.CREATED);
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = DateTimeUtil.toEpochSecond(LocalDateTime.now());
    }

}
