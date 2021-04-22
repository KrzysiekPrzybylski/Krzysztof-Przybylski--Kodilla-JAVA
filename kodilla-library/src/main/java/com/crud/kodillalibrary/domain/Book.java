package com.crud.kodillalibrary.domain;





import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer yearOfPublication;



    private List<BookCopy> booksCopy = new ArrayList<>();

    public Book(String title, String author, Integer yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Book() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name = "YEAR_OF_PUBLICATION")
    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "book"
    )
    public List<BookCopy> getBooksCopy() {
        return booksCopy;
    }

    public void setBooksCopy(List<BookCopy> booksCopy) {
        this.booksCopy = booksCopy;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
