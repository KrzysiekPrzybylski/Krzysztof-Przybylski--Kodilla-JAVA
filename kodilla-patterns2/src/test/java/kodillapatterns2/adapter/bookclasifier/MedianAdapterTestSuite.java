package kodillapatterns2.adapter.bookclasifier;

import kodillapatterns2.adapter.bookclasifier.libararya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        Book bookA1 = new Book("Mickiewicz", "Title1", 2001, "Signature1");
        Book bookA2 = new Book("Sienkiewicz", "Title2", 2004, "Signature2");
        Book bookA3 = new Book("Witos", "Title3", 2000, "Signature3");
        Book bookA4 = new Book("Sapkowski", "Title4", 1990, "Signature4");
        Book bookA5 = new Book("Piekara", "Title5", 2010, "Signature5");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(bookA1);
        bookSet.add(bookA2);
        bookSet.add(bookA3);
        bookSet.add(bookA4);
        bookSet.add(bookA5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2001, median);
    }
}
