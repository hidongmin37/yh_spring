package study.data_jpa.repsitory;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import study.data_jpa.dto.MemberDto;
import study.data_jpa.entity.Member;
import study.data_jpa.entity.Team;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	TeamRepository teamRepository;


	@PersistenceContext
	EntityManager entityManager;

	@Test
	public void testMember() {
		System.out.println("memberRepository = " + memberRepository);
		Member member = new Member("memberA");
		Member savedMember = memberRepository.save(member);
		Member findMember = memberRepository.findById(savedMember.getId()).get();


		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		assertThat(findMember).isEqualTo(member);
	}

	@Test
	public void basicCRUD() {
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		memberRepository.save(member1);
		memberRepository.save(member2);

		Member findMember1 = memberRepository.findById(member1.getId()).get();
		Member findMember2 = memberRepository.findById(member2.getId()).get();

		Assertions.assertThat(findMember1).isEqualTo(member1);
		Assertions.assertThat(findMember2).isEqualTo(member2);

		List<Member> all = memberRepository.findAll();
		Assertions.assertThat(all.size()).isEqualTo(2);
		memberRepository.delete(member1);
		memberRepository.delete(member2);

		List<Member> afterAll = memberRepository.findAll();
		Assertions.assertThat(afterAll.size()).isEqualTo(0);
	}

	@Test
	public void findByUsernameAndAgeGreaterThen() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);

		List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("BBB", 15);

		Assertions.assertThat(result.get(0).getUsername()).isEqualTo("BBB");
		Assertions.assertThat(result.get(0).getAge()).isEqualTo(20);
		Assertions.assertThat(result.size()).isEqualTo(1);

	}

	@Test
	public void testNamedQuery() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);
		List<Member> result = memberRepository.findByUsername("AAA");
		Member findMember = result.get(0);
		Assertions.assertThat(findMember).isEqualTo(member);

	}

	@Test
	public void testQuery() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);
		List<Member> result = memberRepository.findUser("AAA",10);
		Member findMember = result.get(0);
		Assertions.assertThat(findMember).isEqualTo(member);

	}

	@Test
	public void findUsernameList() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);
		List<String> usernameList = memberRepository.findUsernameList();

		Assertions.assertThat(usernameList.get(0)).isEqualTo(member.getUsername());
		Assertions.assertThat(usernameList.get(1)).isEqualTo(member2.getUsername());
	}

	@Test
	public void findMemberDto() {
		Team team = new Team("teamA");
		teamRepository.save(team);

		Member member = new Member("BBB", 20);
		memberRepository.save(member);

		List<MemberDto> memberDto = memberRepository.findMemberDto();
		for (MemberDto dto : memberDto) {
			System.out.println("dto = " + dto);
		}

	}
	// findByNames

	@Test
	public void findMemberNames() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);
		List<Member> byNames = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));

		for (Member byName : byNames) {
			System.out.println("byName = " + byName);
		}

	}

	@Test
	public void returnType() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberRepository.save(member);
		memberRepository.save(member2);

		//list는 절대 null 값이 아님
		List<Member> listByUsername = memberRepository.findListByUsername("asd");

		// 단건인 경우에는 null이됨(없을경우)
		Member memberByUsername = memberRepository.findMemberByUsername(member.getUsername());

		// Optional로쓰면 null값발생
		Optional<Member> optionalByUsername = memberRepository.findOptionalByUsername(member.getUsername());

		System.out.println("memberByUsername = " + memberByUsername);

		for (Member byName : listByUsername) {
			System.out.println("byName = " + byName);
		}

	}

	@Test
	public void paging() {

		//given
		memberRepository.save(new Member("member1", 10));
		memberRepository.save(new Member("member2", 10));
		memberRepository.save(new Member("member3", 10));
		memberRepository.save(new Member("member4", 10));
		memberRepository.save(new Member("member5", 10));
		memberRepository.save(new Member("member6", 10));

		int age = 10;
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

		//when
		//slice는 토탈쿼리 안날아감
		Page<Member> page = memberRepository.findByAge(age, pageRequest);
		// long totalElements = page.getTotalElements();

		//dto외부로 반
		Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));


		//then
		List<Member> content = page.getContent();
		for (Member member : content) {
			System.out.println("member = " + member);
		}
		// System.out.println("totalElements = " + totalElements);

		Assertions.assertThat(content.size()).isEqualTo(3);
		// Assertions.assertThat(page.getTotalElements()).isEqualTo(6);
		Assertions.assertThat(page.getNumber()).isEqualTo(0);
		// Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
		Assertions.assertThat(page.isFirst()).isTrue();
		Assertions.assertThat(page.hasNext()).isTrue();
	}

	@Test
	public void bulkUpdate() {
		memberRepository.save(new Member("member1", 10));
		memberRepository.save(new Member("member2", 19));
		memberRepository.save(new Member("member3", 20));
		memberRepository.save(new Member("member4", 21));
		memberRepository.save(new Member("member5", 40));

		int result = memberRepository.bulkAgePlus(20);

		assertThat(result).isEqualTo(3);


		List<Member> all = memberRepository.findAll();
		for (Member member : all) {
			System.out.println("member = " + member);
		}

	}

	@Test
	public void findMemberLazy() {
		//given
		//member1-> teamA
		//member2-> teamB

		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		teamRepository.save(teamA);
		teamRepository.save(teamB);
		Member memberA = new Member("memberA", 21, teamA);
		Member memberB = new Member("memberB", 40, teamB);

		memberRepository.save(memberA);
		memberRepository.save(memberB);

		entityManager.flush();
		entityManager.clear();
		/*
		* N+1문제가 나옴
		* */
		List<Member> all = memberRepository.findMemberEntityGraph();
		for (Member member : all) {
			System.out.println("member = " + member.getUsername());
			System.out.println("memberTeamClass = " + member.getTeam().getClass());
			System.out.println("memberTeam = " + member.getTeam());
		}
	}

	@Test
	public void findMemberLazyFetch() {
		//given
		//member1-> teamA
		//member2-> teamB

		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		teamRepository.save(teamA);
		teamRepository.save(teamB);
		Member memberA = new Member("memberA", 21, teamA);
		Member memberB = new Member("memberB", 40, teamB);

		memberRepository.save(memberA);
		memberRepository.save(memberB);

		entityManager.flush();
		entityManager.clear();
		/*
		 * N+1문제가 나옴
		 * */
		List<Member> all = memberRepository.findMemberFetchJoin();
		for (Member member : all) {
			System.out.println("member = " + member.getUsername());
			System.out.println("memberTeamClass = " + member.getTeam().getClass());
			System.out.println("memberTeam = " + member.getTeam());
		}
	}

	@Test
	public void queryHint() {
		Member member = new Member("member1", 10);
		memberRepository.save(member);
		entityManager.flush();
		entityManager.clear();

		Member findMember = memberRepository.findReadOnlyByUsername(member.getUsername()); // 읽기로만 쓰고 변경감지 체크를 안함
		findMember.setUsername("member2");

		entityManager.flush();
		System.out.println("findMember.getUsername() = " + findMember.getUsername());

	}

	@Test
	public void lock() {
		Member member = new Member("member1", 10);
		memberRepository.save(member);
		entityManager.flush();
		entityManager.clear();

		List<Member> lockByUsername = memberRepository.findLockByUsername(member.getUsername());
	}

	@Test
	public void callCustom() {
		Member member = new Member("member1", 10);
		memberRepository.save(member);
		entityManager.flush();
		entityManager.clear();

		List<Member> memberCustom = memberRepository.findMemberCustom();
		System.out.println("memberCustom = " + memberCustom);
	}

	@Test
	public void JpaEventBaseEntity() throws InterruptedException {
		//given
		Member member = new Member("member1");
		memberRepository.save(member); // @PrePersist가 발생
		//when



		entityManager.flush();
		entityManager.clear();

		Member findMember = memberRepository.findById(member.getId()).get();


		//then
		System.out.println("findMember = " + findMember);
		System.out.println("findMember createDate= " + findMember.getCreatedDate());
		System.out.println("findMember updatedDate = " + findMember.getUpdatedDate());
	}

}