package com.manish.lms.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.lms.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}