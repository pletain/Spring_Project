package hello.core.Order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {
    MemberService memberService;
    OrderService orderService;

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
}