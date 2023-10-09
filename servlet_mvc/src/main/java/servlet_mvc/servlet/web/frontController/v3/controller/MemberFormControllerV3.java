package servlet_mvc.servlet.web.frontController.v3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.web.frontController.ModelView;
import servlet_mvc.servlet.web.frontController.MyView;
import servlet_mvc.servlet.web.frontController.v2.ControllerV2;
import servlet_mvc.servlet.web.frontController.v3.ControllerV3;

import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
