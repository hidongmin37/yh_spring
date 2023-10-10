package servlet_mvc.servlet.web.frontController.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.web.frontController.ModelView;
import servlet_mvc.servlet.web.frontController.MyView;
import servlet_mvc.servlet.web.frontController.v4.ControllerV4;
import servlet_mvc.servlet.web.frontController.v5.MyHandlerAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // #3에서 반환했던 것 반환  == #1에서 반환했던것과 동일
        ControllerV4 controllerV4 = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>(); // 추가 된 부분
        String viewName = controllerV4.process(paramMap, model);

        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);

        return modelView;
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
