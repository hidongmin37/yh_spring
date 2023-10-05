package yshello1.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import yshello1.core.annotation.MainDiscountPolicy;
import yshello1.core.member.Grade;
import yshello1.core.member.Member;

@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {

            return 0;
        }

    }
}
