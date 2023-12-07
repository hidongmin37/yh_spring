package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;


    /*
    * memberService     @Transactional :OFF
    * memberRepository  @Transactional :ON
    * logRepository     @Transactional :ON
    * */
    @Test
    void outerTxOff_success() {
        //given
        String username = "outerTxOff_success";

        //when : 모든 데이터가 정상 저장된다.
        memberService.joinV1(username);

        //then
        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());

    }

    /*
     * memberService     @Transactional :OFF
     * memberRepository  @Transactional :ON
     * logRepository     @Transactional :ON Exception이 여기서 날아옴
     * */
    @Test
    void outerTxOff_fail() {
        //given
        String username = "로그예외_outerTxOff_fail";

        //when : 모든 데이터가 정상 저장된다.
//        memberService.joinV1(username);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        //then
        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isEmpty());

    }

    /*
     * memberService     @Transactional :ON
     * memberRepository  @Transactional :OFF
     * logRepository     @Transactional :OFF
     * */

    @Test
    void singleTx() {
        //given
        String username = "singleTx";

        //when : 모든 데이터가 정상 저장된다.
        memberService.joinV1(username);


        //then
        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());

    }


    /*
     * memberService     @Transactional :ON
     * memberRepository  @Transactional :ON
     * logRepository     @Transactional :ON
     * */

    @Test
    void outerTxOn_success() {
        //given
        String username = "outerTxOn_success";

        //when : 모든 데이터가 정상 저장된다.
        memberService.joinV1(username);


        //then
        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());

    }

    /*
     * memberService     @Transactional :ON
     * memberRepository  @Transactional :ON
     * logRepository     @Transactional :ON Exception이 여기서 날아옴
     * */
    @Test
    void outerTxOn_fail() {
        //given
        String username = "로그예외_outerTxOn_fail";


        org.assertj.core.api.Assertions.assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        //then 모든 데이터 롤백
        Assertions.assertTrue(memberRepository.find(username).isEmpty());
        Assertions.assertTrue(logRepository.find(username).isEmpty());

    }


    /*
     * memberService     @Transactional :ON
     * memberRepository  @Transactional :ON
     * logRepository     @Transactional :ON Exception이 여기서 날아옴
     * */
    @Test
    void recoverException_fail() {
        //given
        String username = "로그예외_recoverException_fail";


        org.assertj.core.api.Assertions.assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        //then 모든 데이터 롤백
        Assertions.assertTrue(memberRepository.find(username).isEmpty());
        Assertions.assertTrue(logRepository.find(username).isEmpty());

    }
    /*
     * memberService     @Transactional :ON
     * memberRepository  @Transactional :ON
     * logRepository     @Transactional :ON (Requires_new)
     * */
    @Test
    void recoverException_success() {
        //given
        String username = "로그예외_recoverException_success";


        memberService.joinV2(username);

        //then 멤버 저장, 로그는 롤백
        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isEmpty());

    }

}