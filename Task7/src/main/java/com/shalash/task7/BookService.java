package com.shalash.task7;


import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // Simulating a database with an in-memory list of books
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Adding some books to the list
        books.add(new Book(1,"Clean Code", "tawfeek"));
        books.add(new Book(2,"Effective Java", "mohamed"));
        books.add(new Book(3,"Design Patterns", "tawfeek"));
    }

    public Book getBookByTitle(String title) {
        // Simulate fetching a book by title
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null); // If not found, return null
    }

    public Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
}
