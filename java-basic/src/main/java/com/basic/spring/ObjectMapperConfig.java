package com.basic.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ObjectMapperConfig {

//    @Bean
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper();
//    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // LocalDateTime 직렬화 설정
        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        );
        javaTimeModule.addSerializer(LocalDateTime.class, localDateTimeSerializer);

        // LocalDate 직렬화 설정
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        );
        javaTimeModule.addSerializer(LocalDate.class, localDateSerializer);

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer objectMapperBuilderCustomizer() {
//        return builder -> {
//            LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyyMMdd hhmmss.SSS"));
//
//            builder.serializerByType(LocalDateTime.class, localDateTimeSerializer);
//        };
//    }

}
