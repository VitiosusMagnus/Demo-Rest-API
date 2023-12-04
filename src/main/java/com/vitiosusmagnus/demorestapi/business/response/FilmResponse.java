package com.vitiosusmagnus.demorestapi.business.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmResponse {
    private long id;
    private String name;
    private String url;
    private String actors;
    private double rating;
    private String description;
}
