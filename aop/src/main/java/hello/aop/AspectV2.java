package hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV2 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder() {
    }  //포인트컷 시그니쳐

    //클래스 이름 패턴이 *Service인 것.
    @Pointcut("execution(* *..*Service.*(..))")
    private void allService() {
    }

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature()); //join point 시그니처
        return joinPoint.proceed();
    }

    @Around("allService() && allOrder()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[transaction 시작] {}", joinPoint.getSignature()); //join point 시그니처
            Object result = joinPoint.proceed();
            log.info("[transaction 종료] {}", joinPoint.getSignature()); //join point 시그니처
            return result;
        } catch (Exception e) {
            log.info("[transaction 롤백] {}", joinPoint.getSignature()); //join point 시그니처
            throw e;
        } finally {
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature()); //join point 시그니처
        }

    }
}
