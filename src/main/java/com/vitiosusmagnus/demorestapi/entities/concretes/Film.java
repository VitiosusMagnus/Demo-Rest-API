package com.vitiosusmagnus.demorestapi.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String url;
    @Column
    private String actors;
    @Column
    private double rating;
    @Column(length = 1000, nullable = false)
    private String description;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Review> reviews;


}
