package com.javabegin.bookslibrary.repository;

import com.javabegin.bookslibrary.domain.Author;
import com.javabegin.bookslibrary.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Page<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName (String name,String fio, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.content =: content, b.id =: id")
   void updateContent(@Param("content") byte[] content,@Param("id") long id);

    @Query("select new Book(b.id, b.image) from Book b")
    List<Book> findTopBooks(Pageable pageable);

    @Query("select new Book(b.name, b.pageCount,b.isbn,b.genre,b.publishYear, b.publisher, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.descr,b.author) from Book b where b.genre.id=:id")
    Page<Book> findByGenre(@Param("id") long id, Pageable peagable );

    @Query("select b.content from Book b where b.id =:id")
    byte[] getContent (@Param("id") long id);

    @Modifying
    @Query("update Book b set b.viewCount =: viewCount where b.id =: id")
    void updateViewCount(@Param("viewCount") int viewCount,@Param("id") long id);

    @Modifying
    @Query("update Book b set b.totalVoteCount=:totalVoteCount, b.totalRating=:totalRating, b.avgRating=:avgRating where b.id =:id")
    void updateRating(@Param("totalRating") long totalRating, @Param("totalVoteCount") long totalVoteCount,  @Param("avgRating") int avgRating, @Param("id") long id);


}
