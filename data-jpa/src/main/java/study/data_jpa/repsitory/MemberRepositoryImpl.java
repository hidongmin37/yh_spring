package study.data_jpa.repsitory;

import java.util.List;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import study.data_jpa.entity.Member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

	private final EntityManager entityManager;


	@Override
	public List<Member> findMemberCustom() {
		return entityManager.createQuery("select m From Member m",Member.class)
			.getResultList();
	}
}
