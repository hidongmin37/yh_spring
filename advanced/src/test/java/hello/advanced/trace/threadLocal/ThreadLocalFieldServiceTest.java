package hello.advanced.trace.threadLocal;

import hello.advanced.trace.threadLocal.code.FieldService;
import hello.advanced.trace.threadLocal.code.ThreadLocalFieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalFieldServiceTest {

    private ThreadLocalFieldService service = new ThreadLocalFieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = ()-> {
            service.logic("userA");
        };
        Runnable userB = ()-> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(1); //동시성 문제 발생X
//        sleep(100);
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
