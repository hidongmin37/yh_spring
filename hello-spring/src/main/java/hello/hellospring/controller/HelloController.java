package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
     public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; //hello.html로 가서 실행시키라는 것
     } // hello를 get으로 해서  resource/templates/hello.html과 연결해서

     @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-templates";
    };


    // 화면에 그대로 리턴값 자체를 내려줌. 이것을 쓸일이 별로 없음.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "안녕 귀염둥이 " + name;
    };


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
