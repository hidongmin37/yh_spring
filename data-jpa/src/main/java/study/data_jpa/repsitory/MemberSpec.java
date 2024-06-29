package study.data_jpa.repsitory;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import study.data_jpa.entity.Member;

public class MemberSpec {

	public static Specification<Member> teamName(final String teamName) {
		return (root, query, criteriaBuilder) -> {
			if (StringUtils.isEmpty(teamName)) {
				return null;
			}

			Join<Object, Object> team = root.join("team", JoinType.INNER);//회원과 조인
			return criteriaBuilder.equal(team.get("name"), teamName);
		};
	}

	public static Specification<Member> username(final String username) {
		return (root, query, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("username"), username);
	}
}
