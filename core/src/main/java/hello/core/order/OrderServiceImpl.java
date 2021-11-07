package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
// 이제 구체 클래스를 의존하지 않아도 됨.
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
// @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // @Autowired
    // void setMemberRepository(MemberRepository memberRepository) {
    //     this.memberRepository = memberRepository;
    // }

    // @Autowired
    // void setDiscountpolicy(DiscountPolicy discountPolicy) {
    //     this.discountPolicy = discountPolicy;
    // }
    
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }

    
}