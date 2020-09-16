package com.javabegin.bookslibrary.service;

import com.javabegin.bookslibrary.dao.GenreDao;
import com.javabegin.bookslibrary.domain.Genre;
import com.javabegin.bookslibrary.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre get(long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()) return genre.get();
        else throw new NullPointerException("Genre does not exist");
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
    genreRepository.delete(genre);
    }

    @Override
    public List<Genre> search(String... key) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(key[0]) ;
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction direction, String... key) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(key[0], PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }

    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction direction) {
        return genreRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }
}
