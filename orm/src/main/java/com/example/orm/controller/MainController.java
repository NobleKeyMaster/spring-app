package com.example.orm.controller;


import com.example.orm.models.Book;
import com.example.orm.models.Review;
import com.example.orm.repository.BookRepository;
import com.example.orm.repository.ReviewRepository;
import com.example.orm.service.BookInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/main")
public class MainController {

    private final BookRepository bookRepository;

    private final ReviewRepository reviewRepository;

//    private final BookInitializer bookInitializer;

    @Autowired
    public MainController(BookRepository bookRepository, ReviewRepository reviewRepository, BookInitializer bookInitializer) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
//        this.bookInitializer = bookInitializer;
    }

    @GetMapping("/page")
    public String main(Model model) {
//        bookInitializer.removeAll();
        Iterable<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "main/books";
    }

    @GetMapping("/review/{id}")
    public String reviewForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> bookList = bookRepository.findById(id);
        Book book = bookList.get();
        model.addAttribute("id", id);
        model.addAttribute("book", book);
        return "main/review";
    }

    @PostMapping("/add")
    public String addReview(@RequestParam("review") Review review, Model model) {
//        Optional<Book> bookList = bookRepository.findById(id);
//        Book book = bookList.get();
//        book.setReviews();
        return "redirect:/main/page";
    }



}
