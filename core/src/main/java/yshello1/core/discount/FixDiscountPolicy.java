package yshello1.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import yshello1.core.member.Grade;
import yshello1.core.member.Member;

@Component
//@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum타입에서는 == 비교가 맞다.
            return discountFixAmount;
        } else {
            return 0;
        }


    }
}
