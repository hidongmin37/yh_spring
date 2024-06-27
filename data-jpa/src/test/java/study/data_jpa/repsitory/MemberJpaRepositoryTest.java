package study.data_jpa.repsitory;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import study.data_jpa.entity.Member;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberJpaRepositoryTest {

	@Autowired
	MemberJpaRepository memberJpaRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Test
	public void testMember() {
		Member member = new Member("memberA");
		Member savedMember = memberJpaRepository.save(member);
		Member findMember = memberJpaRepository.find(savedMember.getId());

		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		assertThat(findMember).isEqualTo(member);
	}

	@Test
	public void basicCRUD() {
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		memberJpaRepository.save(member1);
		memberJpaRepository.save(member2);

		Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
		Member findMember2 = memberJpaRepository.findById(member2.getId()).get();

		Assertions.assertThat(findMember1).isEqualTo(member1);
		Assertions.assertThat(findMember2).isEqualTo(member2);

		List<Member> all = memberJpaRepository.findAll();
		Assertions.assertThat(all.size()).isEqualTo(2);
		memberJpaRepository.delete(member1);
		memberJpaRepository.delete(member2);

		List<Member> afterAll = memberJpaRepository.findAll();
		Assertions.assertThat(afterAll.size()).isEqualTo(0);
	}

	@Test
	public void findByUsernameAndAgeGreaterThen() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberJpaRepository.save(member);
		memberJpaRepository.save(member2);

		List<Member> result = memberJpaRepository.findByUsernameAndAgeGreaterThan("BBB", 15);

		Assertions.assertThat(result.get(0).getUsername()).isEqualTo("BBB");
		Assertions.assertThat(result.get(0).getAge()).isEqualTo(20);
		Assertions.assertThat(result.size()).isEqualTo(1);

	}

	@Test
	public void testNamedQuery() {
		Member member = new Member("AAA", 10);
		Member member2 = new Member("BBB", 20);

		memberJpaRepository.save(member);
		memberJpaRepository.save(member2);
		List<Member> result = memberJpaRepository.findByUsername("AAA");
		Member findMember = result.get(0);
		Assertions.assertThat(findMember).isEqualTo(member);


	}

	@Test
	public void paging() {

		//given
		memberJpaRepository.save(new Member("member1", 10));
		memberJpaRepository.save(new Member("member2", 10));
		memberJpaRepository.save(new Member("member3", 10));
		memberJpaRepository.save(new Member("member4", 10));
		memberJpaRepository.save(new Member("member5", 10));
		memberJpaRepository.save(new Member("member6", 10));
		memberJpaRepository.save(new Member("member7", 10));
		memberJpaRepository.save(new Member("member8", 10));

		int age = 10;
		List<Member> byPage = memberJpaRepository.findByPage(age, 0, 4);

		for (Member member : byPage) {
			System.out.println("member1 = " + member);
		}

		List<Member> byPage2 = memberJpaRepository.findByPage(age, 4, 4);
		for (Member member : byPage2) {
			System.out.println("member2 = " + member);
		}
		long ageCount = memberJpaRepository.totalCount(10);
		Assertions.assertThat(ageCount).isEqualTo(8);
	}

	@Test
	public void bulkUpdate() {
		memberJpaRepository.save(new Member("member1", 10));
		memberJpaRepository.save(new Member("member2", 19));
		memberJpaRepository.save(new Member("member3", 20));
		memberJpaRepository.save(new Member("member4", 21));
		memberJpaRepository.save(new Member("member5", 40));

		int result = memberJpaRepository.bulkAgePlus(20);

		Assertions.assertThat(result).isEqualTo(3);

		entityManager.flush(); // 영속성 컨텍스트에서 디비에 변경되지 않은 것들이 디비에 반영
		entityManager.clear();
		List<Member> all = memberJpaRepository.findAll();
		for (Member member : all) {
			System.out.println("member = " + member);
		}

	}
}