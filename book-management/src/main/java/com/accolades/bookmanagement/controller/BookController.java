package com.accolades.bookmanagement.controller;

import com.accolades.bookmanagement.dto.BookResponse;
import com.accolades.bookmanagement.dto.RequestPayload;
import com.accolades.bookmanagement.model.Book;
import com.accolades.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmgmt")
public class BookController{

    @Autowired
    BookService bookService;

    @PostMapping(value = "/savebook" )
    public ResponseEntity<Book> saveBook(@RequestBody RequestPayload requestPayload) {
        final Book book = bookService.saveBook(requestPayload);
        return  ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<?> getAllBooks() {
        final List<BookResponse> bookResponses = bookService.fetchAllBooks();
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(bookResponses);
    }

    @GetMapping("/deletebookbyid/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookid") String bookid) {
        bookService.deleteBookById(Integer.parseInt(bookid));
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Book deleted...");
    }

    @GetMapping("/getBookById/{bookid}")
    public ResponseEntity<?> getBookById(@PathVariable("bookid") String bookid) {
        final BookResponse bookById = bookService.getBookById(Integer.parseInt(bookid));
        return ResponseEntity.status(HttpStatus.OK).body(bookById);

    }
}



