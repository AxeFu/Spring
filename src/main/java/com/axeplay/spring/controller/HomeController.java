package com.axeplay.spring.controller;

import com.axeplay.spring.model.Book;
import com.axeplay.spring.repo.BookRepository;
import com.axeplay.spring.service.SoundAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;
    private SoundAnimals soundAnimals;
    @Autowired
    public HomeController(BookRepository bookRepository, @Qualifier("catSound") SoundAnimals soundAnimals) {
        this.soundAnimals = soundAnimals;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String getIndex(Model model) {
        System.out.println("From Controller: " + soundAnimals.sound());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newbook", new Book());
        return "index";
    }

    @PostMapping
    public String createBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

}
