package com.javabegin.bookslibrary.repository;

import com.javabegin.bookslibrary.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "writers")
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    List<Publisher> findByNameContainingIgnoreCaseOrderByName (String name);
    Page<Publisher> findByNameContainingIgnoreCaseOrderByName (String name, Pageable pageable);
}
