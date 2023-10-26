package com.hello.typeConverter;

import com.hello.typeConverter.converter.IntegerToStringConverter;
import com.hello.typeConverter.converter.IpPortToStringConverter;
import com.hello.typeConverter.converter.StringToIntegerConverter;
import com.hello.typeConverter.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
    }
}
