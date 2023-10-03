package yshello1.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yshello1.core.discount.DiscountPolicy;
import yshello1.core.discount.FixDiscountPolicy;
import yshello1.core.discount.RateDiscountPolicy;
import yshello1.core.member.Member;
import yshello1.core.member.MemberRepository;
import yshello1.core.member.MemberServiceImpl;
import yshello1.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {



    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private DiscountPolicy discountPolicy;
    private final MemberRepository  memberRepository;
    private final DiscountPolicy discountPolicy;
//    private  MemberRepository  memberRepository;
//    private  DiscountPolicy discountPolicy;
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    // Test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
