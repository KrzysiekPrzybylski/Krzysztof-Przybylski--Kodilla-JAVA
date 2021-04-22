package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "BOOK_COPY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;
    private boolean isBorrowed;
    @ManyToOne
    private Book book;
}
