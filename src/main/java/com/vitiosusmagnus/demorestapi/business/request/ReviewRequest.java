package com.vitiosusmagnus.demorestapi.business.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    @NotBlank
    @NotNull
    @Size(max = 1000)
    private String comment;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    @Min(0)
    @Max(5)
    private int rating;
}
