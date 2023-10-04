package yshello1.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import yshello1.core.discount.FixDiscountPolicy;
import yshello1.core.member.Grade;
import yshello1.core.member.Member;

import yshello1.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(  1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        org.assertj.core.api.Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}