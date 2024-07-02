package study.querydsl;

import static com.querydsl.jpa.JPAExpressions.*;
import static org.assertj.core.api.Assertions.*;
import static study.querydsl.entity.QMember.*;
import static study.querydsl.entity.QTeam.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.QTeam;
import study.querydsl.entity.Team;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

	@Autowired
	EntityManager entityManager;

	JPAQueryFactory jpaQueryFactory;
	@BeforeEach
	public void before() {
		jpaQueryFactory = new JPAQueryFactory(entityManager);
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
	}

	@Test
	public void startJPQL() {
		//member1을 찾아라
		Member findByJpql = entityManager.createQuery("select m from Member m"+
				" where m.username = :username",Member.class)
			.setParameter("username", "member1")
			.getSingleResult();

		assertThat(findByJpql.getUsername()).isEqualTo("member1");
	}

	@Test
	public void startQuerydsl() {
		// JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
		// QMember m = new QMember("m");
		// QMember m = QMember.member;

		Member member1 = jpaQueryFactory.select(member)
			.from(member)
			.where(member.username.eq("member1")) //파라미터 바인딩
			.fetchOne();


		assertThat(member1.getUsername()).isEqualTo("member1");
	}

	@Test
	public void search() {
		Member member1 = jpaQueryFactory.selectFrom(member)
			.where(member.username.eq("member1")
				// .and(member.age.eq(10)))
				.and(member.age.between(10,30)))
			.fetchOne();

		assertThat(member1.getUsername()).isEqualTo("member1");

	}

	@Test
	public void searchAndParam() {
		Member member1 = jpaQueryFactory.selectFrom(member)
			.where(member.username.eq("member1"),member.age.between(10,30))
				// .and(member.age.eq(10)))
				// .and(,member.username.eq("member1")))
			.fetchOne();
		assertThat(member1.getUsername()).isEqualTo("member1");

	}

	@Test
	public void resultFetch() {
		List<Member> fetch = jpaQueryFactory.selectFrom(member)
			.fetch();

		Member fetchOne = jpaQueryFactory.selectFrom(member)
			.where(member.username.eq("member1"))
			.fetchOne();

		Member fetchFirst = jpaQueryFactory.selectFrom(member)
			.fetchFirst();

		QueryResults<Member> memberQueryResults = jpaQueryFactory.selectFrom(member)
			.fetchResults();// 이제는 fetchResults() 대신 fetch 사용
		long total = memberQueryResults.getTotal();
		List<Member> contents = memberQueryResults.getResults();
		memberQueryResults.getLimit();

		long l = jpaQueryFactory.selectFrom(member)
			.fetchCount(); //이것도 fetch후에 size로 나오게 해야함.
	}

	/*회원 정렬순서
	* 1. 회원나이 내림차순
	* 2. 회원나이 올림차순
	* 3. 2에서 회원이름이 없으면 마지막에 출력*/
	@Test
	public void sort() {

		Member member4= new Member(null, 100);
		Member member5 = new Member("member5", 100);
		Member member6 = new Member("member6", 100);
		entityManager.persist(member4);
		entityManager.persist(member5);
		entityManager.persist(member6);

		List<Member> memberJPAQuery = jpaQueryFactory.selectFrom(member)
			.where(member.age.eq(100))
			.orderBy(member.age.desc(), member.username.asc().nullsLast()).fetch();
		Member member1 = memberJPAQuery.get(0);
		Member member2 = memberJPAQuery.get(1);
		Member member3 = memberJPAQuery.get(2);

		assertThat(member1.getUsername()).isEqualTo("member5");
		assertThat(member2.getUsername()).isEqualTo("member6");
		assertThat(member3.getUsername()).isNull();
	}

	@Test
	public void paging1() {
		QueryResults<Member> fetchResults = jpaQueryFactory.selectFrom(member)
			.orderBy(member.username.desc())
			.offset(1)
			.limit(2)
			.fetchResults();

		assertThat(fetchResults.getTotal()).isEqualTo(4);
		assertThat(fetchResults.getLimit()).isEqualTo(2);
		assertThat(fetchResults.getOffset()).isEqualTo(1);
		assertThat(fetchResults.getResults().size()).isEqualTo(2);
	}

	@Test
	public void aggregation() {
		List<Tuple> fetch = jpaQueryFactory.select(member.count(),
				member.age.sum(),
				member.age.avg(),
				member.age.max(),
				member.age.min())
			.from(member)
			.fetch();

		Tuple tuple = fetch.get(0);
		assertThat(tuple.get(member.count())).isEqualTo(4);
		assertThat(tuple.get(member.age.sum())).isEqualTo(100);
		assertThat(tuple.get(member.age.avg())).isEqualTo(25);
		assertThat(tuple.get(member.age.max())).isEqualTo(40);
		assertThat(tuple.get(member.age.min())).isEqualTo(10);

	}

	/*팀의 이름과 각 팀의 평균 연령을 구해라*/
	@Test
	public void group() throws Exception {
		List<Tuple> fetch = jpaQueryFactory.select(
				team.name, member.age.avg())
			.from(member)
			.join(member.team, team)
			.groupBy(team.name)
			.fetch();

		Tuple tuple = fetch.get(0);
		Tuple tuple1 = fetch.get(1);

		assertThat(tuple.get(team.name)).isEqualTo("teamA");
		assertThat(tuple.get(member.age.avg())).isEqualTo(15);
		assertThat(tuple1.get(team.name)).isEqualTo("teamB");
		assertThat(tuple1.get(member.age.avg())).isEqualTo(35);
	}

	/*팀 A에 소속된 모든 회원 */
	@Test
	public void join() {
		List<Member> fetch = jpaQueryFactory
			.selectFrom(member)
			.leftJoin(member.team, team)
			.where(team.name.eq("teamA"))
			.fetch();

		assertThat(fetch)
			.extracting("username")
			.containsExactly("member1", "member2");
	}

	@Test
	public void theta_join() {
		entityManager.persist(new Member("teamA"));
		entityManager.persist(new Member("teamB"));
		entityManager.persist(new Member("teamC"));

		List<Member> fetch = jpaQueryFactory.select(member)
			.from(member, team)
			.where(member.username.eq(team.name))
			.fetch();

		assertThat(fetch)
			.extracting("username")
			.containsExactly("teamA", "teamB");

	}

	/*
	* 예) 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인, 회원은 모두 조회
	* JPQL: select m, t from Member m left join m.team t on t.name= 'teamA'*/
	@Test
	public void join_on_filtering() {
		List<Tuple> fetch = jpaQueryFactory
			.select(member, team)
			.from(member)
			// .join(member.team, team).on(team.name.eq("teamA"))
			.join(member.team, team).where(team.name.eq("teamA"))
			.fetch();
		/*left join(외부조인)에는 on이 답이다*/

		for (Tuple tuple : fetch) {
			System.out.println("tuple = " + tuple);
		}
	}

	/*연관관계가 없는 엔티티를 외부 조인
	* 회원의 이름이 팀 이름과 같은 대상 외부조인*/
	@Test
	public void join_on_no_relation() {
		entityManager.persist(new Member("teamA"));
		entityManager.persist(new Member("teamB"));
		entityManager.persist(new Member("teamC"));

		List<Tuple> fetch = jpaQueryFactory.select(member, team)
			.from(member)
			// .join(team) // 팀 있는 것만 가져옴
			// .leftJoin(team)
			.leftJoin(member.team,team)// on절이 빠짐 //team id일치하는 것 들 가져옴
			.on(member.username.eq(team.name))
			.fetch();

		for (Tuple tuple : fetch) {
			System.out.println("tuple = " + tuple);
		}
	}

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Test
	public void fetchJoinNo() {
		entityManager.flush();
		entityManager.clear();


		Member findMember = jpaQueryFactory
			.selectFrom(member)
			.join(member.team,team).fetchJoin()
			.where(member.username.eq("member1"))
			.fetchOne();

		// Member findMember = jpaQueryFactory
		// 	.selectFrom(member)
		// 	.where(member.username.eq("member1"))
		// 	.fetchOne();



		boolean loaded = entityManagerFactory.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
		// assertThat(loaded).as("페치 조인 미적용").isFalse();
		assertThat(loaded).as("페치 조인 적용").isTrue();

	}


	/*나이가 가장 많은 회원 조회
	*/
	@Test
	public void subQuery() {
		QMember memberSub = new QMember("memberSub");

		List<Member> fetch = jpaQueryFactory
			.selectFrom(member)
			.where(member.age.eq(
				select(memberSub.age.max())
					.from(memberSub)
			))
			.fetch();

		assertThat(fetch).extracting("age")
			.containsExactly(40);
	}

	/*나이가 평균 이상인 회원
	 */
	@Test
	public void subQueryGoe() {
		QMember memberSub = new QMember("memberSub");

		List<Member> fetch = jpaQueryFactory
			.selectFrom(member)
			.where(member.age.goe(
				select(memberSub.age.avg())
					.from(memberSub)
			))
			.fetch();

		assertThat(fetch).extracting("age")
			.containsExactly(30,40);
	}


	@Test
	public void subQueryIn() {
		QMember memberSub = new QMember("memberSub");

		List<Member> fetch = jpaQueryFactory
			.selectFrom(member)
			.where(member.age.in(
				select(memberSub.age)
					.from(memberSub)
					.where(memberSub.age.gt(10))
			))
			.fetch();

		assertThat(fetch).extracting("age")
			.containsExactly(20,30,40);
	}

	@Test
	public void selectSubQuery() {
		QMember memberSub = new QMember("memberSub");

		List<Tuple> fetch = jpaQueryFactory
			.select(member.username,
				select(memberSub.age.avg())
					.from(memberSub)
			)
			.from(member)
			.fetch();
		for (Tuple tuple : fetch) {
			System.out.println("tuple = " + tuple);
		}
	}

	@Test
	public void basicCase() {
		List<String> fetch = jpaQueryFactory
			.select(member.age
				.when(10).then("열살")
				.when(20).then("스무살")
				.otherwise("기타")
			).from(member).fetch();

		for (String s : fetch) {
			System.out.println("s = " + s);
		}

	}

	@Test
	public void complexCase() {
		List<String> fetch = jpaQueryFactory
			.select(new CaseBuilder()
				.when(member.age.between(0, 20)).then("0~20살")
				.when(member.age.between(21, 30)).then("21~30살")
				.otherwise("기타")
			).from(member)
			.fetch();

		for (String s : fetch) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void constant() {
		List<Tuple> fetch = jpaQueryFactory
			.select(member.username, Expressions.constant("A"))
			.from(member)
			.fetch();

		for (Tuple tuple : fetch) {
			System.out.println("tuple = " + tuple);
		}
	}

	@Test
	public void concat() {
		List<String> fetch = jpaQueryFactory
			.select(member.username.concat("_").concat(member.age.stringValue()))
			.from(member)
			.where(member.username.eq("member1"))
			.fetch();

		for (String s : fetch) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void simpleProjection() {
		List<String> result = jpaQueryFactory
			.select(member.username)
			.from(member)
			.fetch();

		for (String s : result) {
			System.out.println("s = " + s);
		}
	}

	@Test
	public void tupleProjection() {
		List<Tuple> result = jpaQueryFactory
			.select(member.username, member.age)
			.from(member)
			.fetch();

		for (Tuple tuple : result) {
			String username = tuple.get(member.username);
			Integer age = tuple.get(member.age);
			System.out.println("username = " + username);
			System.out.println("age = " + age);
		}
	}

}
