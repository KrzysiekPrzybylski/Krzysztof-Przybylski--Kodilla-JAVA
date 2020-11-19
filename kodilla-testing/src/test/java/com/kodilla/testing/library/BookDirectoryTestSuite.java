package com.kodilla.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private List<Book> generateListOfNBook(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n=1; n<=booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBook = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBook.add(book1);
        resultListOfBook.add(book2);
        resultListOfBook.add(book3);
        resultListOfBook.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBook);

        //When
        List<Book> theListOfBook = bookLibrary.listBookswithCondtition("Secret");

        //Then
        assertEquals(4,theListOfBook.size());

    }
    @Test
    void testListBooksWithConditionMoreThan20() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Book = new ArrayList<>();
        List<Book> resultListOf15Book = generateListOfNBook(15);
        List<Book> resultListOf40Book = generateListOfNBook(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Book);
        when(libraryDatabaseMock.listBooksWithCondition("Zero Books")).thenReturn(resultListOf0Book);
        when(libraryDatabaseMock.listBooksWithCondition("Forty Books")).thenReturn(resultListOf40Book);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBookswithCondtition("Zero Books");
        List<Book> theListOfBooks15 = bookLibrary.listBookswithCondtition("Any title");
        List<Book> theListOfBook40 = bookLibrary.listBookswithCondtition("Forty Books");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15,theListOfBooks15.size());
        assertEquals(0, theListOfBook40.size());

    }
    //@Test
    void testListBooksWithConditionFragmentShorterThan3() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Book = generateListOfNBook(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Book);

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBookswithCondtition("An");

        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }


    @Test
    void testListBooksInHandsOfWithZeroBooks() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listZeroBooks = new ArrayList<>();
        LibraryUser libraryUser = new LibraryUser("Stefan", "Senegal", "8546");
        when(libraryDatabaseMock.listBooksInHandsOff(libraryUser)).thenReturn(listZeroBooks);

        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(0,resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOff(libraryUser);
    }
    @Test
    void testListBookInHandsOfOneBook() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOneBook = generateListOfNBook(1);
        LibraryUser libraryUser = new LibraryUser("Stefan", "Senegal", "8546");
        when(libraryDatabaseMock.listBooksInHandsOff(libraryUser)).thenReturn(listOneBook);

        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(1, resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOff(libraryUser);
    }
    @Test
    void testListBookInHandsOfFiveBooks() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listFiveBooks = generateListOfNBook(5);
        LibraryUser libraryUser = new LibraryUser("Stefan", "Senegal", "8546");
        when(libraryDatabaseMock.listBooksInHandsOff(libraryUser)).thenReturn(listFiveBooks);

        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(5,resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOff(libraryUser);
    }
}

