package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) { // required
        model.addAttribute("name", name); // key, name
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http body 부분에 이 데이터를 직접 넣겠다는 의미, 소스 코드 보기를 하면 html 태그 없이 return 값만 보이게 됨
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; 
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json으로 반환
    }

    static class Hello {
        // 자바 빈 규약
        private String name; // 외부에서 꺼내서 사용할 수 없음, 메소드를 이용해서 접근 가능

        // getter, setter -> 프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
