package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repositoryV1;

    @BeforeEach
    void beforeEach() {
        //기본 DriverManager를 통한 항상 새로운 커넥션을 획득
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        //커넥션 풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repositoryV1 = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        //저장
        Member memberV0 = new Member("memberV0", 10000);
        repositoryV1.save(memberV0);

        //아이디 찾기
        Member foundId = repositoryV1.findById(memberV0.getMemberId());
        Assertions.assertThat(foundId).isEqualTo(memberV0);

        log.info("findMember = {}", foundId);

        // money 수정
        repositoryV1.update(memberV0.getMemberId(), 2000);
        Member memberV1 = new Member("memberV0", 20000);
        Assertions.assertThat(memberV1).isNotEqualTo(memberV0);
        Assertions.assertThat(memberV1).isEqualTo(new Member("memberV0", 20000));

        //member 삭제
        repositoryV1.delete(memberV0.getMemberId());
        Assertions.assertThatThrownBy(() -> repositoryV1.findById(memberV0.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}