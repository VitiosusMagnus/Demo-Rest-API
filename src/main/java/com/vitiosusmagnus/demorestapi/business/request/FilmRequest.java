package com.vitiosusmagnus.demorestapi.business.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmRequest {
    private String name;
    private String url;
    private String actors;
    private String description;
}
