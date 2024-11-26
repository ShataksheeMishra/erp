package com.shatakshee.erp.dto;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;




    public record PlacementStudentRequest (

        @NotNull(message = "Placement ID is required")
        @JsonProperty("placement_id")
         Integer placementId,


        @NotNull(message = "CV Application must be provided")
        @NotEmpty(message = "CV Application cannot be empty")
        @NotBlank(message = "CV Application cannot be blank")
        @JsonProperty("cv_application")
         String cvApplication,

        @JsonProperty("about")
        @Size(max = 500, message = "About section cannot exceed 500 characters")
         String about
    ){



    }


