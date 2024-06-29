package study.querydsl.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","name"})
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "team_id")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team")
	public List<Member> members = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}
}
