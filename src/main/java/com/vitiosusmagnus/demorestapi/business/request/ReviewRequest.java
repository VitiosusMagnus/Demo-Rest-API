package com.vitiosusmagnus.demorestapi.business.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    @NotBlank
    @NotNull
    private String comment;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private int rating;
}
