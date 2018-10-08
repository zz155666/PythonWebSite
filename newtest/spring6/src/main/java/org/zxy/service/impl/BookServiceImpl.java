package org.zxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zxy.domain.Book;
import org.zxy.mapper.BookMapper;
import org.zxy.service.BookService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> getAll() {
        return bookMapper.findAll();
    }
}
