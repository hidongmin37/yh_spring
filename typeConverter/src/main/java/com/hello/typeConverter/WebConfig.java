package com.hello.typeConverter;

import com.hello.typeConverter.converter.IntegerToStringConverter;
import com.hello.typeConverter.converter.IpPortToStringConverter;
import com.hello.typeConverter.converter.StringToIntegerConverter;
import com.hello.typeConverter.converter.StringToIpPortConverter;
import com.hello.typeConverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override//스프링이 들고있는 기본적인 서비스에 등록이 됨.
    public void addFormatters(FormatterRegistry registry) {

        //우선순위때문에 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
