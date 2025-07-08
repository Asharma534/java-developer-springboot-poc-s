package com.accolades.bookmanagement.service;

import com.accolades.bookmanagement.dto.BookResponse;
import com.accolades.bookmanagement.dto.RequestPayload;
import com.accolades.bookmanagement.model.Book;
import com.accolades.bookmanagement.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService{

    @Autowired
    BookRepository bookRepository;

    BookService(){
        System.out.println("Book Service initialized !!!!");
    }

    public Book saveBook(RequestPayload request){

        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        return bookRepository.save(book);
    }

    public List<BookResponse> fetchAllBooks(){
        final List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponseList = new ArrayList<>();
        BookResponse   bookResponse = new BookResponse();
        if(Objects.nonNull(books)) {
            books.stream().forEach(book -> {
                bookResponse.setId(book.getId());
                bookResponse.setAuthor(book.getAuthor());
                bookResponse.setTitle(book.getTitle());

                bookResponseList.add(bookResponse);
            });
        }
        return bookResponseList;
    }

    public BookResponse getBookById(Integer bookId){
        final Optional<Book> bookById = bookRepository.findById(bookId);
        BookResponse bookResponse = new BookResponse();
        if(bookById.isPresent()) {
            final Book book = bookById.get();
            bookResponse.setId(book.getId());
            bookResponse.setAuthor(book.getAuthor());
            bookResponse.setTitle(book.getTitle());

        }else {
            throw new RuntimeException("Book not found based on given bookId...." + bookById);
        }
        return bookResponse;
    }

    public void  deleteBookById(Integer bookId){
        final Optional<Book> bookById = bookRepository.findById(bookId);
        if (bookById.isPresent()) {
            bookRepository.deleteById(bookId);
        }
        else {
            throw new RuntimeException("No book present with given bookid");
        }
    }
        @PostConstruct
        public void init () {
            System.out.println("Book Service init!!!!!!");
            System.out.println("bookRepository initiazed !!!!");
        }
    }

