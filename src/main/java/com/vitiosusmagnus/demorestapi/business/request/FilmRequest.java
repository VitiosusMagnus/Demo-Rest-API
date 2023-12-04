package com.vitiosusmagnus.demorestapi.business.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmRequest {
    @NotBlank
    @NotNull
    private String name;
    private String url;
    private String actors;
    @Size(max = 1000)
    private String description;
}
