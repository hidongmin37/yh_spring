package hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {
    @Around("hello.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //@Before
            log.info("[transaction 시작] {}", joinPoint.getSignature()); //join point 시그니처
            Object result = joinPoint.proceed();
            //@AfterReturning
            log.info("[transaction 종료-] {}", joinPoint.getSignature()); //join point 시그니처
            return result;
        } catch (Exception e) {
            //@AfterThrowing
            log.info("[transaction 롤백] {}", joinPoint.getSignature()); //join point 시그니처
            throw e;
        } finally {
            //@After
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature()); //join point 시그니처
        }

    }

    @Before("hello.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
//        log.info("hello");
        log.info("[Before] {}", joinPoint.getSignature());

    }

    @AfterReturning(value = "hello.aop.Pointcuts.orderAndService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        log.info("[return] {} return={}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "hello.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint,Exception ex) {
        log.info("[ex] {} message={}",ex);

    }


    @After(value = "hello.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }
}
