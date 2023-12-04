package com.vitiosusmagnus.demorestapi.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Size(max = 1000)
    private String comment;
    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private int rating;
    @ManyToOne
    private Film film;
}
