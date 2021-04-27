package kodillapatterns2.adapter.bookclasifier;

import kodillapatterns2.adapter.bookclasifier.libararya.Book;
import kodillapatterns2.adapter.bookclasifier.libararya.Classifier;
import kodillapatterns2.adapter.bookclasifier.libararyb.BookSignature;
import kodillapatterns2.adapter.bookclasifier.libararyb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    public MedianAdapter() {
        super();
    }

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, kodillapatterns2.adapter.bookclasifier.libararyb.Book> mapOfBook = new HashMap<>();

        for(Book book:bookSet) {
            mapOfBook.put(new BookSignature(book.getSignature()),
                    new kodillapatterns2.adapter.bookclasifier.libararyb.Book(book.getAuthor(),book.getTitle(),book.getPublicationYear()));
        }
        return medianPublicationYear(mapOfBook);
    }
}