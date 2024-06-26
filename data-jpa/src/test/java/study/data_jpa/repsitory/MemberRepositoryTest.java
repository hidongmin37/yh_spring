package study.data_jpa.repsitory;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
}