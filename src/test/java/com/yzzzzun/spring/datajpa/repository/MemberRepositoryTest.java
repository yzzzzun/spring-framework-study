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
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@DisplayName("Member 추가 테스트 - Spring Data Jpa사용")
	@Test
	void testAddMember() {
		Member member = new Member("memberA", 20);
		Member savedMember = memberRepository.save(member);
		Member findMember = memberRepository.findById(savedMember.getId()).get();

		assertThat(findMember).isEqualTo(savedMember);
	}

}
