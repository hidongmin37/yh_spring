package study.querydsl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import study.querydsl.entity.Hello;
import study.querydsl.entity.QHello;

@SpringBootTest
@Transactional
@Commit
class QuerydslApplicationTests {

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
		Hello hello = new Hello();
		entityManager.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(entityManager);
		QHello qHello = new QHello("h");
		Hello hello1 = query.selectFrom(qHello)
			.fetchOne();

		Assertions.assertThat(hello1).isEqualTo(hello);
		Assertions.assertThat(hello1.getId()).isEqualTo(hello.getId());

	}

}
