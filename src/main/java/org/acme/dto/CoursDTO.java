package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public class CoursDTO {
    @NotBlank
    public String titre;

    @NotBlank
    public String description;
    
    @NotBlank
    public String professeur;
    
}
