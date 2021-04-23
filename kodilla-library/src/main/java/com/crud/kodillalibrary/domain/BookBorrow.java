package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "BOOK_BORROW")
public class BookBorrow {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @OneToOne
    private BookCopy bookCopy;
}
