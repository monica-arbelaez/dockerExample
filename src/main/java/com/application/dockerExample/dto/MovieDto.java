package com.application.dockerExample.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
    private String movieName;
    private String category;
}
