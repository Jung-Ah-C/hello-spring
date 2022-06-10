package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 스프링을 시작하게 될 때 만들어지는 스프링 컨테이너에 @Controller가 붙은 것들의 객체를 미리 만들어줌, 그리고 스프링이 이를 관리함
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 생성자에 @Autowired을 붙이면, 스프링 컨테이너에 있는 것을 자동으로 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
