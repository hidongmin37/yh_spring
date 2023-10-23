package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")//false인 이유는 로그인 안한사용자도 들어와야해서
    public String homeLogin(@CookieValue(name = "memberId",required = false) Long memberId, Model model){

        if (memberId == null){
            log.info("1단계");
            return "home";
        }

        //로그인한 사용자

        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null){
            log.info("2단계");
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}