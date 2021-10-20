package hello.core.Order;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
}