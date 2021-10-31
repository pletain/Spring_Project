package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService SingletonService1 = SingletonService.getInstance();
        SingletonService SingletonService2 = SingletonService.getInstance();

        System.out.println(SingletonService1);
        System.out.println(SingletonService2);

        Assertions.assertThat(SingletonService1).isSameAs(SingletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void SpringContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //조회
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}