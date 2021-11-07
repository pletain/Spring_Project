package hello.core.autowired;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

public class AllBeanTest {
    
    

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member memberA = new Member(1L, "UserA", Grade.VIP);
        int discountPrice = discountService.discount(memberA, 100000, "fixDisCountPolicy");
        System.out.println("discountPrice = " + discountPrice);

        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap =" + policyMap);
            System.out.println("policies =" + policies);

        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountpolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountpolicy);

            return policyMap.get(discountCode).discount(member, price);
        }
    }
}