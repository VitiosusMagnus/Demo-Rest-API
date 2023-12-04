package com.vitiosusmagnus.demorestapi.business.response;

import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<Review> reviews;

}
