package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Member;
import kr.re.kitri.hello.model.Post;
import kr.re.kitri.hello.service.MemberService;
import kr.re.kitri.hello.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by danawacomputer on 2017-06-16.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 글쓰기 화면 보기
     */
    @GetMapping("/regist")
    public String regist() {
        return "member/regist";
    }

    /**
     * 실제 글쓰기
     */
    @PostMapping("/do_regist")
    public ModelAndView do_regist(Member member) {
        System.out.println("member");

        memberService.registMember(member);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/do_write");
        mav.addObject("member", member);

        return mav;
    }
}
