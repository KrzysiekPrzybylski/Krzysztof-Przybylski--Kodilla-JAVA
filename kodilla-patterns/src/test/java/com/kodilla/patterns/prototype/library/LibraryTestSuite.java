package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Library Warka");
        Book book1 = new Book("Sapkowski", "Wiedzmin", LocalDate.of(1998,5,12));
        Book book2 = new Book("Jacek Piekara", "Inkwizytor", LocalDate.of(2004,5,30));
        Book book3 = new Book("Piekara" , "Plomien i krzyz", LocalDate.of(2010,8,24));
        Book book4 = new Book("Krzysztof Spadło", "Skazaniec", LocalDate.of(2018, 8,12));

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library Grojec");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library Siedlce");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When

        library.removeBook(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(3, library.getBooks().size());
        assertEquals(3, clonedLibrary.getBooks().size());
        assertEquals(4, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks().size(), clonedLibrary.getBooks().size());
        assertNotEquals(clonedLibrary.getBooks().size(), deepClonedLibrary.getBooks().size());


    }
}
