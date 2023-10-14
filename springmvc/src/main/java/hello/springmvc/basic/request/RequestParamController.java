package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("userName={}, age={}" ,userName,age);

        response.getWriter().write("OK");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("userName") String userName,
            @RequestParam("age") int age) {
        log.info("userName={}, age={}" ,userName,age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String userName,
            @RequestParam int age) {
        log.info("userName={}, age={}" ,userName,age);
        return "OK";
    }


    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String userName,
            int age) {
        log.info("userName={}, age={}" ,userName,age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public  String requestParamRequired(
           @RequestParam(required = false) String userName,
           @RequestParam(required = true) Integer age) {
        log.info("userName={}, age={}" ,userName,age);

        return "OK";
    }


    @ResponseBody
    @RequestMapping("/request-param-default")
    public  String requestParamDefault(
            @RequestParam(required = false,defaultValue = "guest") String userName,
            @RequestParam(required = true,defaultValue = "-1") int age) {
        log.info("userName={}, age={}" ,userName,age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public  String requestParamMap(
            @RequestParam Map<String,Integer> paramMap) {


        log.info("userName={}, age={}" ,paramMap.get("userName"),paramMap.get("age"));

        return "OK";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String userName,@RequestParam int age){
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
//        helloData.setUsername(userName);
//        helloData.setAge(age);
        log.info("helloData userName = {}",helloData.getUserName());
        log.info("helloData age = {}",helloData.getAge());
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2") //ModelAttribute 생략가능
    public String modelAttributeV2(HelloData helloData){
        log.info("helloData userName = {}",helloData.getUserName());
        log.info("helloData age = {}",helloData.getAge());
        return "OK";
    }
}
