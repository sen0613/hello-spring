package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by danawacomputer on 2017-06-12.
 * <p>
 * /bbs .. 전체보기
 * /bbs/15 .. 상세보기
 * /bbs/15/modify .. 수정(15번 글 수정)
 * /bbs/15/remove .. 삭제(15번 글 삭제)
 * /bbs/write .. 글 작성 화면 로딩
 * /bbs/write/do .. 글 작성하기
 */
@Controller
public class BbsController {
    @RequestMapping("/bbs")
    public String viewAll() {
        return "view_all";
    } /*bbs .. 전체보기*/

    @RequestMapping("/bbs/{articleId}")
    public ModelAndView viewDetail(@PathVariable("articleId") String articleId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("bbs/view_detail");
        mav.addObject("articleId", articleId);
        return mav;
    }

    @RequestMapping(value="/bbs/write", method=RequestMethod.GET)
    public String loading() {
        return "bbs/write";
    }

    @RequestMapping(value="/bbs/write", method=RequestMethod.POST)
    public ModelAndView doWrite(Article article) {

        System.out.println(article);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("bbs/do_write");
        mav.addObject("article", article);


        return mav;
    }

//    @RequestMapping("/bbs/write/do")
//    public String writing(HttpServletRequest request) {
//        String articleId = request.getParameter("article_id");
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String content = request.getParameter("content");
//
//        System.out.println(articleId);
//        System.out.println(title);
//        System.out.println(author);
//
//        return "write";
//    }

}
