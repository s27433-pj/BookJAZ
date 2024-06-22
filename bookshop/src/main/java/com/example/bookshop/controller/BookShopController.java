package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookShopController {

    @Autowired
    private BookShopService bookShopService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookShopService.getAllBooks();
    }

    @GetMapping("/title")
    public List<Book> getBooksByTitle(@RequestParam String title) {
        return bookShopService.filterBooksByTitle(title);

    }

    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookShopService.filterBooksByAuthor(author);
    }

    @PostMapping("/buy")
    public String buyBook(@RequestParam String title) {
        return bookShopService.buyBook(title);
    }
}