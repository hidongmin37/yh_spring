package servlet_mvc.servlet.web.frontController.v3;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*") // 이 하위에서는 서블릿 호출
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI(); // 주소창에 url받아오기

        ControllerV3 controllerV3 = controllerV3Map.get(requestURI);
        if (controllerV3 ==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Map<String, String> paramMap = createParamMap(request); // 요청으로 들어온 파라미터들을 Map에 넣기
        ModelView modelView = controllerV3.process(paramMap); // 파라미터를 객체로 생성

        String viewName = modelView.getViewName(); // 객체로 생성한것에서 이름 꺼내기
        MyView view = viewResolver(viewName); // 이름을 일부만 넣었었는데, 거기에서 합쳐주기
        view.render(modelView.getModel(),request, response);  //이 안에서는 dispatcher해주는데, 메소드를 만들어서 모델을 넣어줌.

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
