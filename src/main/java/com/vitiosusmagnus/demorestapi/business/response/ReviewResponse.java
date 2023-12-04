package com.vitiosusmagnus.demorestapi.business.response;


import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private long id;
    private String name;
    private String comment;
    private int rating;
    private Film film;
}
