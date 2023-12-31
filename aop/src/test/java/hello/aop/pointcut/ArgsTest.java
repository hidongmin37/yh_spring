package hello.aop.pointcut;

import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ArgsTest {

   AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    //표현식에 정확히 해야되고, SuperType은 되지 않음

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        log.info("helloMethod={}", helloMethod);
    }

    private AspectJExpressionPointcut pointcut(String expression) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression); //한번 실행되고 나면 못바꾸기 때문에 실행될때 새로 생성되게 함.
        return pointcut;
    }

    @Test
    void args() {
        Assertions.assertThat(pointcut("args(String)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args(Object)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args()").matches(helloMethod,MemberServiceImpl.class)).isFalse();
        Assertions.assertThat(pointcut("args(..)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args(*)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args(String,..)").matches(helloMethod,MemberServiceImpl.class)).isTrue();

    }

    /*
    * execution(* * (java.io.Serializable)): 메서드의 시그니처로 판단 정적
    * args(java.io.Serializable):런타임에 전달된 인수로 판단 동적
    * */


    @Test
    void argsVsExecution() {
        Assertions.assertThat(pointcut("args(String)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args(java.io.Serializable)").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("args(Object)").matches(helloMethod,MemberServiceImpl.class)).isTrue();

        Assertions.assertThat(pointcut("execution(* *(String))").matches(helloMethod,MemberServiceImpl.class)).isTrue();
        Assertions.assertThat(pointcut("execution(* *(java.io.Serializable))").matches(helloMethod,MemberServiceImpl.class)).isFalse();
        Assertions.assertThat(pointcut("execution(* *(Object))").matches(helloMethod, MemberServiceImpl.class)).isFalse();

    }





}
