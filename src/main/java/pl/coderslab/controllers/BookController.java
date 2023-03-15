package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooksList() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        });
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void delBook(@PathVariable Long id) {
        bookService.delBook(id);
    }




}
