package yshello1.core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import yshello1.core.member.MemberRepository;
import yshello1.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
//        basePackages = "yshello1.core.member" ,//탐색할 페이지의 시작위치를 정해줌. 지정하지 않으면 이게 있는 패키지와 하위패키지 모두 스캔
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class) // 등록을 자동 제거
)
public class AutoAppConfig {
//    @Bean(name="memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
