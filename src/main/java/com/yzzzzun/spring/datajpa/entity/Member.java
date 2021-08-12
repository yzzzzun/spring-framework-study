package com.yzzzzun.spring.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name")
	private String username;

	@Column(name = "age")
	private int age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	protected Member() {
	}

	public Member(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public Team getTeam() {
		return team;
	}
}
