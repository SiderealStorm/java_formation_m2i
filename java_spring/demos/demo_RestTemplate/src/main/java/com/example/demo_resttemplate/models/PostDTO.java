package com.example.demo_resttemplate.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDTO {

    private Long userId;
    private Long id;
    private String title;
    private String body;

}
