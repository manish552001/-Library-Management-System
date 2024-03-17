package com.manish.lms.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.lms.model.Book;
import com.manish.lms.model.IssueBook;
import com.manish.lms.model.Member;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook, Long> {
    List<IssueBook> findByBook(Book book);
        List<IssueBook> findByMember(Member member);
}