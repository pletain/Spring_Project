package hello.core.discount;

import org.springframework.context.annotation.Configuration;

import hello.core.member.Grade;
import hello.core.member.Member;

@Configuration
public class RateDiscountPolicy implements DiscountPolicy {

    private static int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        else
            return 0;
    }

}