package yshello1.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yshello1.core.discount.DiscountPolicy;
import yshello1.core.discount.FixDiscountPolicy;
import yshello1.core.discount.RateDiscountPolicy;
import yshello1.core.member.MemberService;
import yshello1.core.member.MemberServiceImpl;
import yshello1.core.member.MemoryMemberRepository;
import yshello1.core.order.OrderService;
import yshello1.core.order.OrderServiceImpl;

/*
* appconfig는 실제 동작에 필요한 구현 객체를 생성한다.
* */

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return  new OrderServiceImpl(MemberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
