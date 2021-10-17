package hello.core.discount;

import hello.core.member.Member;

public class FixDisCountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        return 0;
    }
    
}