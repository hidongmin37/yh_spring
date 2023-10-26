package com.hello.typeConverter.converter;

import com.hello.typeConverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService(){
        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        Integer result = conversionService.convert("10", Integer.class);
        System.out.println("result = " + result);
        Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        IpPort result2 = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(result2).isEqualTo(new IpPort("127.0.0.1",8080));


        String result3 = conversionService.convert(new IpPort("127.0.0.1",8080),String.class);
        Assertions.assertThat(result3).isEqualTo("127.0.0.1:8080");

    }

}
