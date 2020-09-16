package com.javabegin.bookslibrary.service;

import com.javabegin.bookslibrary.dao.AuthorDao;
import com.javabegin.bookslibrary.domain.Author;
import com.javabegin.bookslibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorSerivce implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()) return author.get();
        else throw new NullPointerException("Author does not exist");
    }

    @Override
    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public void delete(Author author) {
    authorRepository.delete(author);
    }

    @Override
    public List<Author> search(String... key) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(key[0]);
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction direction, String... key) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(key[0],PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }

    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction direction) {
        return authorRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }
}
