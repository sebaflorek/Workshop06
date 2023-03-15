package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            bookRepository.save(book);
        }
    }

    @Override
    public void delBook(Long id) {
        bookRepository.deleteById(id);
    }
}
