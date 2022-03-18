package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //요즘은 거의 안씀
    @GetMapping("hello-string")
    @ResponseBody //http 에서 body part에 아래 내용을 직접 넣어줌.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //json 값으로 전달받게 됨.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
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
    //기본 문자처리 : StringHttpMessageConverter 가 동작
    //기본 객체처리 : MappingJackson2HttpMessageConverter 가 동작

}
