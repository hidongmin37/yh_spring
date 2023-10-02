package yshello1.core.beanFind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yshello1.core.AppConfig;
import yshello1.core.member.Member;
import yshello1.core.member.MemberService;
import yshello1.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //annotaion기반으로 컨피그 설정

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass = " + memberService.getClass());

    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = applicationContext.getBean( MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass = " + memberService.getClass());

    }

    @Test // 구현에 의존한 코드, 유연성 떨어짐
    @DisplayName("구체 타입으로 조회")
    void findBeanByNameExe(){
        MemberService memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameFailed(){
//        MemberService memberService = applicationContext.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,()-> applicationContext.getBean("xxxx", MemberService.class));

    }
}
