package com.kodilla.spring.reader;

public final class Reader {
    Book theBook;

    public Reader(Book theBook) {
        this.theBook = theBook;
    }

    public void read() {
        System.out.println("Readeing: " + theBook.getTitle());
    }
}
