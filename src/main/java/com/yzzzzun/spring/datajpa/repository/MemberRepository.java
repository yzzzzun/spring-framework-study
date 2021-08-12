package com.yzzzzun.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yzzzzun.spring.datajpa.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
