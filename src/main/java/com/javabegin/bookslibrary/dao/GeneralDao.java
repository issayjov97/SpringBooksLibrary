package com.javabegin.bookslibrary.dao;

import com.javabegin.bookslibrary.domain.Author;
import com.javabegin.bookslibrary.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDao<T> {
    List<T> getAll();
    T get (long id);
    T save (T t);
    void delete(T t);
    List<T> search(String... key);
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction direction,String... key);
    List<T> getAll(Sort sort);
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction direction);


}
