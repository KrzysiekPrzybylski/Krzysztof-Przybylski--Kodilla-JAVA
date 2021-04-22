package com.crud.kodillalibrary.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCopyDto {

    private Long bookId;
    private Long bookCopyId;
    private boolean borrowed;
}
