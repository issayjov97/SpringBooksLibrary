package com.javabegin.bookslibrary.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    public Book() {

    }
    public Book(long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Book(String name, int pageCount, String isbn, Genre genre, int publishYear, Publisher publisher,
                Integer avgRating, Long totalVoteCount, Long totalRating, Long viewCount, String descr, Author author) {

        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.descr = descr;
        this.author = author;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(updatable = false)
    private byte[] content;
    @Column(name = "page_count")
    private int pageCount;
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "publish_year")
    private int publishYear;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private byte[] image;
    @Column(name = "avg_rating")
    private Integer avgRating;
    @Column(name = "total_vote_count")
    private Long totalVoteCount;
    @Column(name = "total_rating")
    private Long totalRating;
    @Column(name = "view_count")
    private Long viewCount;
    private String descr;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;



    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
