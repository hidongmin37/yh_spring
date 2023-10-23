package hello.login;


import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1); // 필터가 체인으로 여러개 들어갈 수 있기 때문에 순서를 정함
        filterFilterRegistrationBean.addUrlPatterns("/*");//어떤 URL패턴을 할것이냐
        return filterFilterRegistrationBean;
    }
}
