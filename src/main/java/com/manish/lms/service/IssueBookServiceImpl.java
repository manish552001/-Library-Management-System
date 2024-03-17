package com.manish.lms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.lms.model.Book;
import com.manish.lms.model.IssueBook;
import com.manish.lms.model.Member;
import com.manish.lms.repository.BookRepository;
import com.manish.lms.repository.IssueBookRepository;
import com.manish.lms.repository.MemberRepository;

@Service
public class IssueBookServiceImpl implements IssueBookService {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<IssueBook> getAllIssuedBooks() {
        return issueBookRepository.findAll();
    }

    @Override
    public List<IssueBook> getAllIssuedBooksByMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        return issueBookRepository.findByMember(member);
    }

    @Override
    public List<IssueBook> getAllIssuedBooksByBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return null;
        }
        return issueBookRepository.findByBook(book);
    }

    @Override
    public IssueBook issueBook(Book book, Member member) {
        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book is out of stock.");
        }
        IssueBook issueBook = new IssueBook();
        issueBook.setBook(book);
        issueBook.setMember(member);
        issueBook.setIssueDate(new Date());
        issueBook.setDueDate(getDueDate());
        book.setQuantity(book.getQuantity() - 1); // Decrease available quantity
        bookRepository.save(book);
        return issueBookRepository.save(issueBook);
    }

    @Override
    public IssueBook returnBook(Long issueId) {
        IssueBook issueBook = issueBookRepository.findById(issueId).orElse(null);
        if (issueBook == null) {
            throw new RuntimeException("Issue not found.");
        }
        if (issueBook.isReturned()) {
            throw new RuntimeException("Book already returned.");
        }
        issueBook.setReturnDate(new Date());
        issueBook.setReturned(true);
        Book book = issueBook.getBook();
        book.setQuantity(book.getQuantity() + 1); // Increase available quantity
        bookRepository.save(book);
        return issueBookRepository.save(issueBook);
    }

    private Date getDueDate() {
        // Set due date to 7 days from the issue date
        long currentTime = System.currentTimeMillis();
        long dueTime = currentTime + (7 * 24 * 60 * 60 * 1000); // 7 days in milliseconds
        return new Date(dueTime);
    }
}