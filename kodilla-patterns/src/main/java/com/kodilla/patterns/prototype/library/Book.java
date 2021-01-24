package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public class Book {

    private String name;
    private String title;
    private LocalDate publicationDate;

    public Book(String name, String title, LocalDate publicationDate) {
        this.name = name;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
