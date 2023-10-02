package yshello1.core.discount;

import yshello1.core.member.Grade;
import yshello1.core.member.Member;

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
