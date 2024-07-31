package org.example.buysourcecode.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(unique = true, nullable = false, length = 36)
    private String mail;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar", unique = true)
    private Asset avatar;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

//    public User() {
//        this.role = UserRole.USER;
//        this.avatar = null;
//        this.createdAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
//        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
//        this.status = UserStatus.ACTIVE;
//    }

}
