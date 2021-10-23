package hello.core.discount;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용돼야 함.")
    void vip_check() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 이외엔 할인이 적용 안됨.")
    void else_check() {
        // given
        Member member = new Member(2L, "meberB", Grade.Basic);

        //when
        int discount = discountPolicy.discount(member, 10000);
        
        //then
        assertThat(discount).isEqualTo(0);
    }

}