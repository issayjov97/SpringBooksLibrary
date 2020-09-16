package com.javabegin.bookslibrary.service;

import com.javabegin.bookslibrary.dao.BookDao;
import com.javabegin.bookslibrary.domain.Book;
import com.javabegin.bookslibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {

        return bookRepository.findTopBooks(PageRequest.of(0,limit,Sort.by("viewCount").descending()));
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortValue, Sort.Direction direction, long id) {
        return  bookRepository.findByGenre(id,PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortValue)));
    }

    @Override
    public void updateViewCount(int viewCount, long id) {
        bookRepository.updateViewCount(viewCount,id);
    }

    @Override
    public void updateRating(long totalRating, long totalVoteCount, int avgRating, long id) {
    bookRepository.updateRating(totalRating,totalVoteCount,avgRating,id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(long id) throws NullPointerException {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())return book.get();
        else throw new NullPointerException("Book does not exist");
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        if(book.getContent() != null){
            bookRepository.updateContent(book.getContent(), book.getId());
        }
        return book;
    }

    @Override
    public void delete(Book book) {
    bookRepository.delete(book);
    }

    @Override
    public List<Book> search(String... key) {
        return null;
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction direction, String... key) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(key[0],
                                        key[0],PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction direction) {
        return bookRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(direction,sortField)));
    }
}
