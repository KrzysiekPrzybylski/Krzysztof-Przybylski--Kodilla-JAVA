package com.crud.kodillalibrary.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Integer yearOfPublication;
}
