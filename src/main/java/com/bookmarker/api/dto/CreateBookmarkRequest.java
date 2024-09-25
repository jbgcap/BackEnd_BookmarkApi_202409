package com.bookmarker.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    @NotBlank(message = "Title should not be empty")
    private String title;
    
    @NotEmpty(message = "Url should not be empty")
    private String url;
}