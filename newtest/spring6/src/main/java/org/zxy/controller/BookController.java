package org.zxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zxy.domain.Book;
import org.zxy.service.BookService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping(value = "main")
    public String main(Model model){
        List<Book> book_list=bookService.getAll();
        model.addAttribute("book_list",book_list);
        return "main";
    }
}
