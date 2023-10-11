package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
//    private final Logger log = LoggerFactory.getLogger(getClass()); 둘다 됨

    @RequestMapping("log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok"; // 반환되는 거 원래 view이름 반환,@Controller로 했을 때
        // @RestController라고 하면 http메세지 바디에 데이터를 넣는 것
    }
}
