package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Students")
public class BookController{
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }
    @GetMapping("/")
    public List<Book> getAllBooksAvailable(@RequestParam(required = false) boolean available) {
        List<Book> availableBooks = bookRepository.findByAvailable(available);
        return availableBooks;
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") long id) {
        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isPresent()) {
            return bookData.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(new Book(book.getTitle(),book.getAuthor(),book.getIsbn(),book.getPublishYear(), true));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isPresent()) {
            Book updateBook = bookData.get();
            updateBook.setTitle(book.getTitle());
            updateBook.setAuthor(book.getAuthor());
            updateBook.setIsbn(book.getIsbn());
            updateBook.setPublishYear(book.getPublishYear());
            updateBook.setAvailable(book.isAvailable());
            return bookRepository.save(updateBook);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteBook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
    
    @GetMapping("/searchByTitle")
    public List<Book> findByTitle(@PathVariable("title") String title) {
        return bookRepository.findByTitleContaining(title);
    }
}