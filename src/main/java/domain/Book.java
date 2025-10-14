
package domain;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Book {
    public enum Status { AVAILABLE, CHECKED_OUT, ON_HOLD }

    private final String id;
    private final String title;
    private final String author;
    private Status status = Status.AVAILABLE;
    private LocalDate dueDate;
    private final Deque<String> holdQueue = new ArrayDeque<>();

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String id() { return id; }
    public String title() { return title; }
    public String author() { return author; }
    public Status status() { return status; }
    public void setStatus(Status s) { this.status = s; }
    public LocalDate dueDate() { return dueDate; }
    public void setDueDate(LocalDate d) { this.dueDate = d; }
    public Deque<String> holdQueue() { return holdQueue; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
