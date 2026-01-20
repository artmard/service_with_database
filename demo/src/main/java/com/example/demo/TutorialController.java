package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class bookController {
    private final bookRepository bookRepository;
    public bookController(bookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/books")
    public List<book> getAllbooks(@RequestParam(required =
            false) String title) {
        List<book> books = new ArrayList<book>();
        if (title == null) {
            bookRepository.findAll().forEach(books::add); } else {

            bookRepository.findByTitleContaining(title).forEach(books::add);
        }
        return books;
    }
    @GetMapping("/books/{id}")
    public book getbookById(@PathVariable("id") long id) {
        Optional<book> bookData =
                bookRepository.findById(id);
        if (bookData.isPresent()) {
            return bookData.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/books")
    public book createbook(@RequestBody book book) {
        return bookRepository
                .save(new book(book.getTitle(),
                        book.getDescription(), false));
    }
    @PutMapping("/books/{id}")
    public book updatebook(@PathVariable("id") long id,
                                   @RequestBody book book) {
        Optional<book> bookData =
                bookRepository.findById(id);
        if (bookData.isPresent()) {
            book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setDescription(book.getDescription());
            _book.setPublished(book.isPublished());
            return bookRepository.save(_book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/books/{id}")
    public HttpStatus deletebook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
    @DeleteMapping("/books")
    public HttpStatus deleteAllbooks() {
        bookRepository.deleteAll();
        return HttpStatus.NO_CONTENT;
    }
    @GetMapping("/books/published")
    public List<book> findByPublished() {
        return bookRepository.findByPublished(true);
    }
}