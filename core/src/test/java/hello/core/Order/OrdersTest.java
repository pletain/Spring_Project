package hello.core.Order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrdersTest {
    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "MemberB", Grade.VIP);
        
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "iphone", 20000);

        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);

        
    }
}