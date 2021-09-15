package com.yzzzzun.spring.datajpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.yzzzzun.spring.datajpa.entity.Member;

@Repository
public class MemberJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public Member save(Member member) {
		entityManager.persist(member);
		return member;
	}

	public Member findById(Long id) {
		return entityManager.find(Member.class, id);
	}
}
