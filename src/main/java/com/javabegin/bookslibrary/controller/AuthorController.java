package com.javabegin.bookslibrary.controller;

import com.javabegin.bookslibrary.domain.Author;
import com.javabegin.bookslibrary.service.AuthorSerivce;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
public class AuthorController {

    private AuthorSerivce authorSerivce;

    @Autowired
    public AuthorController(AuthorSerivce authorSerivce) {
        this.authorSerivce = authorSerivce;
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") long id){
        return authorSerivce.get(id);
    }
    @GetMapping
    public List<Author> getAllAuthor(){
        return authorSerivce.getAll();
    }
}
