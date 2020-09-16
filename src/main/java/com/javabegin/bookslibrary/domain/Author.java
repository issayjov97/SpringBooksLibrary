package com.javabegin.bookslibrary.domain;


import io.micrometer.core.annotation.Counted;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "birthday")
    private Date birthday;
    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    @Override
    public String toString() {
        return fio;
    }
}
