package yshello1.core.singleTon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleTon(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = annotationConfigApplicationContext.getBean(StatefulService.class);
        StatefulService statefulService2 = annotationConfigApplicationContext.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원 주문
         int priceA = statefulService1.order("userA",10000);
        // ThreadB : B사용자가 20000원 주문
        int priceB = statefulService2.order("userB",20000);
        
        // ThreadA : 사용자A 주문 금액 조회
//        int price1 = statefulService1.getPrice();
//        System.out.println("price1 = " + price1);
//        // ThreadB : 사용자B 주문 금액 조회
//        int price2 = statefulService2.getPrice();
//        System.out.println("price2 = " + price2);

//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        assertThat(priceA).isEqualTo(10000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}