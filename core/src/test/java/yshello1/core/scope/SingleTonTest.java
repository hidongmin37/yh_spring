package yshello1.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleTonTest {

    @Test
    void singleTonBeanFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean singleTonBean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean singleTonBean2 = ac.getBean(SingleTonBean.class);
        SingleTonBean singleTonBean3 = ac.getBean(SingleTonBean.class);

        System.out.println("singleTonBean1 = " + singleTonBean1);
        System.out.println("singleTonBean2 = " + singleTonBean2);
        System.out.println("singleTonBean3 = " + singleTonBean3);
        Assertions.assertThat(singleTonBean1).isEqualTo(singleTonBean2);
        Assertions.assertThat(singleTonBean2).isEqualTo(singleTonBean3);
        Assertions.assertThat(singleTonBean1).isEqualTo(singleTonBean3);

        ac.close();
    }

    @Scope("singleton") // 싱글톤이 디폴트
    static class SingleTonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingleTonBean.destroy");
        }

    }
}
