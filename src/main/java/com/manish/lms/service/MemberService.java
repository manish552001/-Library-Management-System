package com.manish.lms.service;

import java.util.List;

import com.manish.lms.model.IssueBook;
import com.manish.lms.model.Member;

public interface MemberService {
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    Member saveMember(Member member);
    void deleteMember(Long id);
    List<IssueBook> getMemberHistory(Long memberId);
}
