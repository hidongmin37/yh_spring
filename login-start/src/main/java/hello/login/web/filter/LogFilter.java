package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        long reqTime = 0;
        try {
            reqTime = System.currentTimeMillis();
            log.info("REQUEST [{}][{}]",uuid,requestURI);
            chain.doFilter(request,response);// 다음 필터 호출 , 다음 단계 진행이 안됨
        } catch (Exception e) {
            throw e;
        }finally {
            long respTime = System.currentTimeMillis();
            log.info("RESPONSE [{}][{}], {} ",uuid,requestURI,(respTime - reqTime)/1000.000);
        }

    }

    @Override
    public void destroy() {
        log.info("log filter destroy");

    }
}
