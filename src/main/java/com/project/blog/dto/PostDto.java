package com.project.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;
    @NotEmpty(message = "title should not be empty")
    private String title;
    @NotEmpty(message = "content should not be empty")
    private String content;
    private LocalDateTime postDate;
}
