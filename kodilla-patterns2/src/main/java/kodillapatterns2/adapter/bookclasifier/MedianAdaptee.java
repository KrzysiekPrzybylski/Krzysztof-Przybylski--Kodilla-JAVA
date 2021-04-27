package kodillapatterns2.adapter.bookclasifier;

import kodillapatterns2.adapter.bookclasifier.libararyb.Book;
import kodillapatterns2.adapter.bookclasifier.libararyb.BookSignature;
import kodillapatterns2.adapter.bookclasifier.libararyb.BookStatistics;
import kodillapatterns2.adapter.bookclasifier.libararyb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    private Statistics statistics;

    public MedianAdaptee() {
        this.statistics = new Statistics();
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistics.medianPublicationYear(books);
    }
}
