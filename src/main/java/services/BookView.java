package services;

import domain.Book;
import java.time.LocalDate;

public record BookView(String id, String title, Book.Status status, LocalDate dueDate) {}
