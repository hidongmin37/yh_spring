package hello.springmvc.basic.requestMapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

//    @RequestMapping("/hello-basic")
    @RequestMapping(value = {"/hello-basic","hello-go"},method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
//    @GetMapping("/mapping/{userId}")
//    public String mappingPath(@PathVariable("userId") String data){
//        log.info("mappingPath userId={}", data);
//        return "ok";
//    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId,@PathVariable String orderId){
        log.info("mappingPath userId={}, orderId={}", userId,orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header",headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "/mapping-consumes",consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

//    @PostMapping(value = "/mapping-produce",produces = "text/html")
    @PostMapping(value = "/mapping-produce",produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }



}
