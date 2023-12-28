package hello.proxy.config.v6_aop.aspect;


import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

@Slf4j
@Aspect // 어드바이스랑 포인트컷을 가지고 있는 어드바이저를 편리하게 애노테이션으로 생성함.
public class LogTraceAspect {

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }


    @Around("execution(* hello.proxy.app..*(..))")//pointcut
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        try {
//            Method method = invocation.getMethod();
//            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            //로직 호출
//            Object result = invocation.proceed();
            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
