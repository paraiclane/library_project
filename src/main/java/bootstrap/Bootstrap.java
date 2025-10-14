package bootstrap;

import domain.Book;
import domain.Borrower;
import services.AuthService;
import services.Library;
import util.SystemClock;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bootstrap {

    public static Seed seed() {
        Map<String, Book> books = new LinkedHashMap<>();
        // 20 books — ids B01..B20
        books.put("B01", new Book("B01", "The Great Gatsby", "F. Scott Fitzgerald"));
        books.put("B02", new Book("B02", "To Kill a Mockingbird", "Harper Lee"));
        books.put("B03", new Book("B03", "1984", "George Orwell"));
        books.put("B04", new Book("B04", "Pride and Prejudice", "Jane Austen"));
        books.put("B05", new Book("B05", "Moby-Dick", "Herman Melville"));
        books.put("B06", new Book("B06", "War and Peace", "Leo Tolstoy"));
        books.put("B07", new Book("B07", "The Catcher in the Rye", "J.D. Salinger"));
        books.put("B08", new Book("B08", "Brave New World", "Aldous Huxley"));
        books.put("B09", new Book("B09", "The Hobbit", "J.R.R. Tolkien"));
        books.put("B10", new Book("B10", "Crime and Punishment", "Fyodor Dostoevsky"));
        books.put("B11", new Book("B11", "The Odyssey", "Homer"));
        books.put("B12", new Book("B12", "Ulysses", "James Joyce"));
        books.put("B13", new Book("B13", "The Brothers Karamazov", "Fyodor Dostoevsky"));
        books.put("B14", new Book("B14", "Jane Eyre", "Charlotte Brontë"));
        books.put("B15", new Book("B15", "The Divine Comedy", "Dante Alighieri"));
        books.put("B16", new Book("B16", "Frankenstein", "Mary Shelley"));
        books.put("B17", new Book("B17", "The Lord of the Rings", "J.R.R. Tolkien"));
        books.put("B18", new Book("B18", "Anna Karenina", "Leo Tolstoy"));
        books.put("B19", new Book("B19", "The Grapes of Wrath", "John Steinbeck"));
        books.put("B20", new Book("B20", "Fahrenheit 451", "Ray Bradbury"));

        Map<String, Borrower> borrowers = new LinkedHashMap<>();
        borrowers.put("alice", new Borrower("alice", "pass1"));
        borrowers.put("bob", new Borrower("bob", "pass2"));
        borrowers.put("carol", new Borrower("carol", "pass3"));

        var auth = new AuthService(borrowers);
        var lib  = new Library(books, borrowers, new SystemClock());
        return new Seed(auth, lib);
    }
}
