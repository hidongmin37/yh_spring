package servlet_mvc.servlet.web.springMvc.v3;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import servlet_mvc.servlet.domain.member.Member;
import servlet_mvc.servlet.domain.member.MemberRepository;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form",method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }


    @PostMapping("/save")
    public String save(@RequestParam("userName") String userName,
                             @RequestParam("age") int age,
                             Model model){
        Member member = new Member(userName, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    //"/springmvc/v2/members" 이 친구가 호출됨.
    @GetMapping
    public String list(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
