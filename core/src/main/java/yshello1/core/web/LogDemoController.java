package yshello1.core.web;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yshello1.core.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestUrl = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject(); // provider를 통해서 my logger를 받음
        myLogger.setRequestURL(requestUrl);
        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }

}
