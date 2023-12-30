package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //
@Retention(RetentionPolicy.RUNTIME) // 실제 실행할때까지 런타임이 실행될때 살아있는 것.
public @interface ClassAop {
}
