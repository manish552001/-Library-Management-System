package com.manish.lms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.lms.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// public List<Member> findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
	// public Long countByType(String type);
}
