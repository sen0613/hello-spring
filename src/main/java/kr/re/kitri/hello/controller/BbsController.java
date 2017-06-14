package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.common.MockArticle;
import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @Autowired
    private BbsService service;

    /**
     * \
     * 전체보기
     *
     * @return
     */
    @RequestMapping("/bbs")
    public ModelAndView viewAll() {

        /*bbs .. 전체보기*/
        //전체보기를 하기 위한 데이터를 가져온다.
        MockArticle mock = new MockArticle();
        List<Article> list = mock.getAarticles();


        return new ModelAndView("bbs/view_all")
                .addObject("list", list);
    }

    @RequestMapping("/bbs/{articleId}")
    public ModelAndView viewDetail(@PathVariable String articleId)/*(@PathVariable("articleId") String articleId)*/ {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("bbs/view_detail");
        mav.addObject("articleId", articleId);
        return mav;
    }

    @RequestMapping(value = "/bbs/write", method = RequestMethod.GET)
    public String loading() {
        return "bbs/write";
    }

    @RequestMapping(value = "/bbs/write", method = RequestMethod.POST)
    public ModelAndView doWrite(Article article) {

        System.out.println(article);

        service.registArticle(article);

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
