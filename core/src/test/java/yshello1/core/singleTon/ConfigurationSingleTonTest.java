package yshello1.core.singleTon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yshello1.core.AppConfig;
import yshello1.core.member.MemberRepository;
import yshello1.core.member.MemberService;
import yshello1.core.member.MemberServiceImpl;
import yshello1.core.order.OrderServiceImpl;

public class ConfigurationSingleTonTest {
    
    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = annotationConfigApplicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = annotationConfigApplicationContext.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = annotationConfigApplicationContext.getBean("memberRepository", MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository2 = " + memberRepository2);

        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);

    }
    
    @Test
    void configurationDeep(){
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = annotationConfigApplicationContext.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
