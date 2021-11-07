package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;

public class OrderSerivceImplTest { 


    @Test
    @Autowired
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));

        OrderServiceImpl orderSerivice = new OrderServiceImpl(memberRepository, discountPolicy);
        Order order = orderSerivice.createOrder(1L, "itmeA", 100000);
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(10000);
    }
}