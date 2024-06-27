package study.data_jpa.repsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import study.data_jpa.entity.Member;

@Repository
public class MemberJpaRepository {

	@PersistenceContext
	private EntityManager em;

	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	public void delete(Member member) {
		em.remove(member);
	}

	public List<Member> findAll() {
		return em.createQuery("select m From Member m ", Member.class).getResultList();
	}

	public long count() {
		return em.createQuery("select count(m) from Member m", Long.class).getSingleResult();
	}

	public Optional<Member> findById(Long memberId) {
		Member member = em.find(Member.class, memberId);
		return Optional.ofNullable(member);
	}

	public Member find(Long id) {
		return em.find(Member.class, id);
	}

	public List<Member> findByUsernameAndAgeGreaterThan(String username, int age) {
		return em.createQuery("select m from Member m where m.username = :username and m.age > :age",
				Member.class)
			.setParameter("username", username)
			.setParameter("age", age)
			.getResultList();

	}

	public List<Member> findByUsername(String username) {
		return em.createNamedQuery("Member.findByUsername", Member.class)
			.setParameter("username", username)
			.getResultList();
	}

	public List<Member> findByPage(int age, int offset, int limit) {
		return em.createQuery("select m from Member m where m.age = :age order by m.username desc",Member.class)
			.setParameter("age", age)
			.setFirstResult(offset) // 몇번째부터 가져올거야
			.setMaxResults(limit)// 몇개를 가져올거야
			.getResultList();

	}

	public long totalCount(int age) {
		return em.createQuery("select count(m) from Member m where m.age = :age", Long.class)
			.setParameter("age", age)
			.getSingleResult();
	}

	public int bulkAgePlus(int age) {
		return em.createQuery("update Member m set m.age = m.age + 1 where m.age >= :age")
			.setParameter("age", age)
			.executeUpdate();
	}

}
