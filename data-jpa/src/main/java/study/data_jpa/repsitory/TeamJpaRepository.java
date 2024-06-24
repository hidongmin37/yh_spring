package study.data_jpa.repsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import study.data_jpa.entity.Team;

@Repository
public class TeamJpaRepository {

	@PersistenceContext
	private EntityManager em;

	public Team save(Team Team) {
		em.persist(Team);
		return Team;
	}

	public void delete(Team team) {
		em.remove(team);
	}

	public List<Team> findAll() {
		return em.createQuery("select t from Team t", Team.class).getResultList();
	}


	public long count() {
		return em.createQuery("select count(t) from Team t", Long.class).getSingleResult();
	}

	public Optional<Team> findById(Long teamId) {
		Team team = em.find(Team.class, teamId);
		return Optional.ofNullable(team);
	}

	public Team find(Long id) {
		return em.find(Team.class, id);
	}
}
