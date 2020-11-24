package com.kodilla.stream1.book;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BookTestSuite {

    @Test
    void testListUsingFor () {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> listOfBooks = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for (Book book:  listOfBooks) {
            if(book.getYearOfPublication()>2007) {
                numberOfBooksPublicatedAfter2007 ++;
            }
        }
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
    @Test
    void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> listOfBooks = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, listOfBooks.size())
                .filter(n -> listOfBooks.get(n).getYearOfPublication()>2007)
                .map(n->1)
                .sum();
        assertEquals(3,numberOfBooksPublicatedAfter2007);
    }
    @Test
    void testGetListUsingIntStream1() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

}
