package yshello1.core.componentScan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yshello1.core.AutoAppConfig;
import yshello1.core.member.MemberRepository;
import yshello1.core.member.MemberService;
import yshello1.core.member.MemberServiceImpl;
import yshello1.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac. getBean (OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " +  memberRepository);
    }
}
