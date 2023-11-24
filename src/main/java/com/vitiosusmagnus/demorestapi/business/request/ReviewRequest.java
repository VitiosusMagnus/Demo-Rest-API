package com.vitiosusmagnus.demorestapi.business.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String name;
    private String comment;
    private int rating;
}
