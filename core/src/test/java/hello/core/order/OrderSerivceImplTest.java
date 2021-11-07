package hello.core.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.Order.OrderServiceImpl;

public class OrderSerivceImplTest {


    @Test
    @Autowired
    void createOrder() {
        OrderServiceImpl orderSerivice = new OrderServiceImpl(null, null);
        orderSerivice.createOrder(1L, "itmeA", 100000);
    }
}