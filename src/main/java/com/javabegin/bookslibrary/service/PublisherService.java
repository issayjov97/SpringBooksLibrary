package com.javabegin.bookslibrary.service;

import com.javabegin.bookslibrary.dao.PublisherDao;
import com.javabegin.bookslibrary.domain.Genre;
import com.javabegin.bookslibrary.domain.Publisher;
import com.javabegin.bookslibrary.repository.GenreRepository;
import com.javabegin.bookslibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher get(long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if(publisher.isPresent()) return publisher.get();
        else throw new NullPointerException("Publisher does not exist");
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
    publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> search(String... key) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(key[0]);
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction direction, String... key) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(key[0],PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction direction) {
        return publisherRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }
}
