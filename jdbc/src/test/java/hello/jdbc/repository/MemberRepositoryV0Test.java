package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //저장
        Member memberV0 = new Member("memberV0", 10000);
        repositoryV0.save(memberV0);

        //아이디 찾기
        Member foundId = repositoryV0.findById(memberV0.getMemberId());
        Assertions.assertThat(foundId).isEqualTo(memberV0);

        log.info("findMember = {}", foundId);

        // money 수정
        repositoryV0.update(memberV0.getMemberId(),2000);
        Member memberV1 = new Member("memberV0", 20000);
        Assertions.assertThat(memberV1).isNotEqualTo(memberV0);
        Assertions.assertThat(memberV1).isEqualTo(new Member("memberV0", 20000));

        //member 삭제
        repositoryV0.delete(memberV0.getMemberId());
        Assertions.assertThatThrownBy(() -> repositoryV0.findById(memberV0.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);


    }

}