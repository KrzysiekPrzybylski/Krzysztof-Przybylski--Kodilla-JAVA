package com.crud.kodillalibrary;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class KodillaLibraryApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testBookRepositoryTestSuite() {
        //Given
        Book book = new Book("Potop", "Henryk Sienkiewicz", 1896);
        //When
        bookRepository.save(book);
        //Then
        Long id = book.getId();
        Optional<Book> readBook = bookRepository.findById(id);
        Assertions.assertTrue(readBook.isPresent());
        //CleanUp
        //bookRepository.deleteById(id);
    }
}
