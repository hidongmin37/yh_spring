package servlet_mvc.servlet.web.frontController.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.web.frontController.ModelView;
import servlet_mvc.servlet.web.frontController.MyView;
import servlet_mvc.servlet.web.frontController.v3.ControllerV3;
import servlet_mvc.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import servlet_mvc.servlet.web.frontController.v3.controller.MemberListControllerV3;
import servlet_mvc.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import servlet_mvc.servlet.web.frontController.v4.ControllerV4;
import servlet_mvc.servlet.web.frontController.v4.controller.MemberFormControllerV4;
import servlet_mvc.servlet.web.frontController.v4.controller.MemberListControllerV4;
import servlet_mvc.servlet.web.frontController.v4.controller.MemberSaveControllerV4;
import servlet_mvc.servlet.web.frontController.v5.adapter.ControllerV3HandlerAdapter;
import servlet_mvc.servlet.web.frontController.v5.adapter.ControllerV4HandlerAdapter;

import java.io.IOException;
import java.util.*;


@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>(); // Object타입인 이유는 어떤 컨트롤러 버전이든 상관없이 들어갈 수 있게 설정
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {

        initHandlerMappingMap();
        initHandlerAdapters(); //초기화
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //v4추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());

    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // #1 MemberFormControllerV3,MemberSaveControllerV3,MemberListControllerV3 중 하나 반환
        Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // #3 ControllerV3HandlerAdapter 반환
        MyHandlerAdapter adapter = getHandlerAdapter(handler);


        ModelView modelView = adapter.handle(request, response, handler);

        String viewName = modelView.getViewName(); // 객체로 생성한것에서 이름 꺼내기
        MyView view = viewResolver(viewName); // 이름을 일부만 넣었었는데, 거기에서 합쳐주기
        view.render(modelView.getModel(),request, response);  //이 안에서는 dispatcher해주는데, 메소드를 만들어서 모델을 넣어줌.

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        // #2 #1에서 반환했던 것 반환
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler" + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); // 주소창에 url받아오기
        return handlerMappingMap.get(requestURI);
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
