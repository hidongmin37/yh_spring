package kr.co.neo.restfulservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "My Restful Service API 명세서",
                description = "Spring boot 개발 명세서",
                version = "v1.0.0"
        )
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfigDoc {

        @Bean
        public GroupedOpenApi customTestOpenAPI() {
                String[] paths = {"/users/**", "/admin/**"};
                return GroupedOpenApi.builder()
                        .group("일반 사용자와 관리자를 위한 User도메인 API")
                        .pathsToMatch(paths)
                        .build();
        }
}
