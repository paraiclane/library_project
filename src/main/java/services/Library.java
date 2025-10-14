
package services;

import domain.Book;
import domain.Borrower;
import util.Clock;

import java.util.Map;

public class Library {
    private final Map<String, Book> books;
    private final Map<String, Borrower> borrowers;
    private final Clock clock;

    public Library(Map<String, Book> books, Map<String, Borrower> borrowers, Clock clock) {
        this.books = books;
        this.borrowers = borrowers;
        this.clock = clock;
    }

    public int getBorrowCount(String username) {
        var b = borrowers.get(username);
        if (b == null) throw new IllegalArgumentException("Unknown user: " + username);
        return b.loans().size();
    }

    public Map<String, Book> books() { return books; }
    public Map<String, Borrower> borrowers() { return borrowers; }
    public Clock clock() { return clock; }
}
