package org.example.buysourcecode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 32, nullable = false, unique = true)
    private String slug;

    @Column(length = 64, nullable = false, name = "name_with_type")
    private String nameWithType;

    @Column(length = 2, nullable = false)
    private String code;



}
