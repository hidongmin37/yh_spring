package yshello1.core.discount;

import yshello1.core.member.Member;

public interface DiscountPolicy {


    /*
    * @return 할인 대상 금액(얼마가 할인되었는지)
    * */
    int discount(Member member, int price);
}
