package com.yzzzzun.spring.datajpa.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yzzzzun.spring.datajpa.entity.Member;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

	@Autowired
	private MemberJpaRepository memberJpaRepository;

	@DisplayName("Member 추가 테스트 - Spring Data Jpa사용 없이")
	@Test
	void testAddMember() {
		Member member = new Member("memberA", 20);
		Member savedMember = memberJpaRepository.save(member);
		Member findMember = memberJpaRepository.findById(savedMember.getId());

		assertThat(findMember).isEqualTo(savedMember);
	}
}
