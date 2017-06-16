package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Post;
import kr.re.kitri.hello.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * /post/write (GET) .. 글쓰기 화면
 * /post/write (POST) .. 글 쓰기
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 글쓰기 화면 보기
     */
    @GetMapping("/write")
    public String write() {
        return "post/write";
    }

    /**
     * 실제 글쓰기
     * @param post
     */
    @PostMapping("/write")
    public ModelAndView doWrite(Post post) {
        System.out.println("post");

        postService.registPost(post);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("post/do_write");
        mav.addObject("post", post);

        return mav;
    }
}
