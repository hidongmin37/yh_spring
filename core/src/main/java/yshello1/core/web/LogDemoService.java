package yshello1.core.web;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import yshello1.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject(); //새로 받은
        myLogger.log("service id =" + id);
    }
}
