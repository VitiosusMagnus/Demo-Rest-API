package com.vitiosusmagnus.demorestapi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
