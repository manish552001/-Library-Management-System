package com.manish.lms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.manish.lms.model.Book;
import com.manish.lms.model.IssueBook;
import com.manish.lms.model.Member;
import com.manish.lms.service.BookService;
import com.manish.lms.service.IssueBookService;
import com.manish.lms.service.MemberService;

@RestController
@RequestMapping("/api/issues")
public class IssueBookController {

   @Autowired
    private IssueBookService issueBookService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<IssueBook> getAllIssuedBooks() {
        return issueBookService.getAllIssuedBooks();
    }

    @PostMapping("/issue")
    public IssueBook issueBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        Book book = bookService.getBookById(bookId);
        Member member = memberService.getMemberById(memberId);
        return issueBookService.issueBook(book, member);
    }

    @PostMapping("/return")
    public IssueBook returnBook(@RequestParam Long issueId) {
        return issueBookService.returnBook(issueId);
    }

    @GetMapping("/member/{id}")
    public List<IssueBook> getIssuedBooksByMember(@PathVariable Long id) {
        return issueBookService.getAllIssuedBooksByMember(id);
    }

    @GetMapping("/book/{id}")
    public List<IssueBook> getIssuedBooksByBook(@PathVariable Long id) {
        return issueBookService.getAllIssuedBooksByBook(id);
    }
}