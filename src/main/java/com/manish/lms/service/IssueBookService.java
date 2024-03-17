package com.manish.lms.service;

import java.util.List;

import com.manish.lms.model.Book;
import com.manish.lms.model.IssueBook;
import com.manish.lms.model.Member;

public interface IssueBookService {
    List<IssueBook> getAllIssuedBooks();
    List<IssueBook> getAllIssuedBooksByMember(Long memberId);
    List<IssueBook> getAllIssuedBooksByBook(Long bookId);
    IssueBook issueBook(Book book, Member member);
    IssueBook returnBook(Long issueId);
}
