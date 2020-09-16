package com.javabegin.bookslibrary.dao;

import com.javabegin.bookslibrary.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookDao extends GeneralDao<Book>{
    List<Book> findTopBooks(int limit);
    byte[] getContent(long id);
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortValue, Sort.Direction direction, long id);
    void updateViewCount(int viewCount,long id);
    void updateRating(long totalRating,long totalVoteCount,int avgRating, long id);
}
