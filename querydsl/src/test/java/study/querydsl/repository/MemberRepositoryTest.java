package study.querydsl.repository;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.Team;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

	@Autowired
	EntityManager entityManager;

	@Autowired
	MemberRepository memberRepository;


	@Test
	public void basicTest() {
		Member member = new Member("member1", 10);
		memberRepository.save(member);

		Member member1 = memberRepository.findById(member.getId()).get();
		Assertions.assertThat(member1).isEqualTo(member);

		List<Member> all = memberRepository.findAll();
		Assertions.assertThat(all).containsExactly(member1);

		List<Member> result2 = memberRepository.findByUsername("member1");
		Assertions.assertThat(result2).containsExactly(member1);
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

		List<MemberTeamDto> memberTeamDtos = memberRepository.search(memberSearchCondition);

		Assertions.assertThat(memberTeamDtos).extracting("username").containsExactly("member4");

	}

	@Test
	public void searchPageTest() {
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
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<MemberTeamDto> memberTeamDtos = memberRepository.searchPageSimple(memberSearchCondition, pageRequest);

		assertThat(memberTeamDtos.getSize()).isEqualTo(3);
		Assertions.assertThat(memberTeamDtos).extracting("username").containsExactly("member1","member2","member3");

	}

	@Test
	public void querydslPredicateExecutorTest() {
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

		QMember member = QMember.member;
		Iterable<Member> allMember = memberRepository.findAll(
			member.age.between(5, 40).and(member.username.eq("member1")));

		System.out.println("실행");
		for (Member oneMember : allMember) {
			System.out.println("oneMember = " + oneMember);
		}
	}

}