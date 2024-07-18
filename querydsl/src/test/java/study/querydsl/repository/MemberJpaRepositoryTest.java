package study.querydsl.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

	@Autowired
	EntityManager entityManager;

	@Autowired
	MemberJpaRepository memberJpaRepository;


	@Test
	public void basicTest() {
		Member member = new Member("member1", 10);
		memberJpaRepository.save(member);

		Member member1 = memberJpaRepository.findById(member.getId()).get();
		Assertions.assertThat(member1).isEqualTo(member);

		List<Member> all = memberJpaRepository.findAll();
		Assertions.assertThat(all).containsExactly(member1);

		List<Member> result2 = memberJpaRepository.findByUsername("member1");
		Assertions.assertThat(result2).containsExactly(member1);
	}


	@Test
	public void basicQuerydslTest() {
		Member member = new Member("member1", 10);
		memberJpaRepository.save(member);

		Member member1 = memberJpaRepository.findById(member.getId()).get();
		Assertions.assertThat(member1).isEqualTo(member);

		List<Member> all = memberJpaRepository.findAll();
		Assertions.assertThat(all).containsExactly(member1);

		List<Member> result2 = memberJpaRepository.findByUsername_querydsl("member1");
		Assertions.assertThat(result2).containsExactly(member1);
	}

	@Test
	public void searchQuerydslTest() {
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		entityManager.persist(teamA);
		entityManager.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);

		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);

		entityManager.persist(member1);
		entityManager.persist(member2);
		entityManager.persist(member3);
		entityManager.persist(member4);

		MemberSearchCondition memberSearchCondition = new MemberSearchCondition();
		memberSearchCondition.setAgeGoe(35);
		memberSearchCondition.setAgeLoe(45);
		memberSearchCondition.setTeamName("teamB");

		List<MemberTeamDto> memberTeamDtos = memberJpaRepository.searchByBuilder(memberSearchCondition);

		Assertions.assertThat(memberTeamDtos).extracting("username").containsExactly("member4");

	}

	@Test
	public void searchTest() {
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		entityManager.persist(teamA);
		entityManager.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);

		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);

		entityManager.persist(member1);
		entityManager.persist(member2);
		entityManager.persist(member3);
		entityManager.persist(member4);

		MemberSearchCondition memberSearchCondition = new MemberSearchCondition();
		memberSearchCondition.setAgeGoe(35);
		memberSearchCondition.setAgeLoe(45);
		memberSearchCondition.setTeamName("teamB");

		List<MemberTeamDto> memberTeamDtos = memberJpaRepository.search(memberSearchCondition);

		Assertions.assertThat(memberTeamDtos).extracting("username").containsExactly("member4");

	}


}