package study.querydsl.repository;

import static org.apache.logging.log4j.util.Strings.*;
import static org.springframework.util.StringUtils.*;
import static study.querydsl.entity.QMember.*;
import static study.querydsl.entity.QTeam.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import ch.qos.logback.core.util.StringUtil;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.dto.QMemberDto;
import study.querydsl.dto.QMemberTeamDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.QTeam;

@Repository
@RequiredArgsConstructor
public class MemberJpaRepository {

	private final EntityManager entityManager;
	private final JPAQueryFactory jpaQueryFactory;

	// public MemberJpaRepository(EntityManager entityManager,JPAQueryFactory jpaQueryFactory) {
	// 	this.entityManager = entityManager;
	// 	this.jpaQueryFactory = jpaQueryFactory;
	// }

	public void save(Member member) {
		entityManager.persist(member);
	}

	public Optional<Member> findById(Long id) {
		Member member = entityManager.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	public List<Member> findAll_querydsl() {
		return jpaQueryFactory
			.selectFrom(member)
			.fetch();
	}

	public List<Member> findAll() {
		return entityManager.createQuery("select m from Member m", Member.class)
			.getResultList();
	}

	public List<Member> findByUsername(String username) {

		return entityManager.createQuery("select m from Member m where m.username = :username", Member.class)
			.setParameter("username", username)
			.getResultList();
	}

	public List<Member> findByUsername_querydsl(String username) {

		return jpaQueryFactory
			.selectFrom(member)
			.where(member.username.eq(username))
			.fetch();
	}

	public List<MemberTeamDto> searchByBuilder(MemberSearchCondition condition) {

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (hasText(condition.getUsername())) {
			booleanBuilder.and(member.username.eq(condition.getUsername()));
		}

		if (hasText(condition.getTeamName())) {
			booleanBuilder.and(team.name.eq(condition.getTeamName()));
		}

		if (condition.getAgeGoe() != null) {
			booleanBuilder.and(member.age.goe(condition.getAgeGoe()));
		}

		if (condition.getAgeLoe() != null) {
			booleanBuilder.and(member.age.loe(condition.getAgeLoe()));
		}


		return jpaQueryFactory
			.select(new QMemberTeamDto(
				member.id.as("memberId"),
				member.username,
				member.age,
				team.id.as("teamId"),
				team.name.as("teamName")))
			.from(member)
			.leftJoin(member.team, team)
			.where(booleanBuilder)
			.fetch();

	}

	public List<MemberTeamDto> search(MemberSearchCondition condition) {



		return jpaQueryFactory
			.select(new QMemberTeamDto(
				member.id.as("memberId"),
				member.username,
				member.age,
				team.id.as("teamId"),
				team.name.as("teamName")))
			.from(member)
			.leftJoin(member.team, team)
			.where(
				usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			)
			.fetch();

	}

	private BooleanExpression usernameEq(String username) {
		return hasText(username) ? member.username.eq(username) : null;
	}

	private BooleanExpression teamNameEq(String teamName) {
		return hasText(teamName) ? team.name.eq(teamName) : null;

	}

	private BooleanExpression ageGoe(Integer age) {
		return age != null ? member.age.goe(age) : null;
	}

	private BooleanExpression ageLoe(Integer age) {
		return age != null ? member.age.loe(age) : null;
	}

}
