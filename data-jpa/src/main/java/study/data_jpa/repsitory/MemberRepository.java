package study.data_jpa.repsitory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import study.data_jpa.dto.MemberDto;
import study.data_jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>,MemberRepositoryCustom {

	List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

	// @Query(name = "Member.findByUsername")
	List<Member> findByUsername(@Param("username") String username);

	@Query("select m from Member m where m.username = :username and m.age = :age")
	List<Member> findUser(@Param("username") String username, @Param("age") int age);

	@Query("select m.username from Member m")
	List<String> findUsernameList();

	@Query("select new study.data_jpa.dto.MemberDto(m.id,m.username,t.name) from Member m join m.team t")
	List<MemberDto> findMemberDto();

	@Query("select m from Member m where m.username in :names")
	List<Member> findByNames(@Param("names") Collection<String> names);

	List<Member> findListByUsername(String username); //컬렉션
	Member findMemberByUsername(String username); //단건
	Optional<Member> findOptionalByUsername(String username); // 단건 Optional

	// Page<Member> findByAge(int age, Pageable pageable);

	//카운트 쿼리를 따로 적어주지않으면, 카운트를 하는 로직 에서도 join을 하게됨
	@Query(value = "select m from Member m left join m.team t", countQuery = "select count(m.username) from Member m")
	Page<Member> findByAge(int age, Pageable pageable);

	@Modifying(clearAutomatically = true) //영속성 clear를 자동으로 해줌
	@Query("update Member m set m.age = m.age + 1 where m.age >= :age")
	int bulkAgePlus(@Param("age") int age);

	@Query("select m from Member m left join fetch m.team")
	List<Member> findMemberFetchJoin();

	@Override
	@EntityGraph(attributePaths = {"team"})
	List<Member> findAll();

	@EntityGraph(attributePaths = {"team"})
	@Query("select m from Member m")
	List<Member> findMemberEntityGraph();

	// @EntityGraph("Member.all")
	// List<Member> findByNamedEntityAll();


	@QueryHints(value= @QueryHint(name = "org.hibernate.readOnly",value = "true"))
	Member findReadOnlyByUsername(String username);

	//select for update
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<Member> findLockByUsername(String username);


}
