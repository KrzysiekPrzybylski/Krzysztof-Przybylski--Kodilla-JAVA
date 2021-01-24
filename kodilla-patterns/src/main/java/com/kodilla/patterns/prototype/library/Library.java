package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library implements Cloneable{

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean addBook(Book book) {
        return  books.add(book);
    }
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }
    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.setBooks(new HashSet<>());
        for (Book thebook: books) {
            clonedLibrary.addBook(new Book(thebook.getTitle(), thebook.getName(), thebook.getPublicationDate()));
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for (Book theBook: books) {
            s = s + theBook.toString() + "\n";
        }
        return s;
    }
}
