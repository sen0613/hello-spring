package kr.re.kitri.hello.controller;


import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by danawacomputer on 2017-06-12.
 * /bbs .. 전체보기
 * /bbs/<articleId> .. 상세보기
 * /bbs/<articleId>/modify .. 수정
 * /bbs/<articleId>/remove .. 삭제
 * <p>
 * /bbs/write .. 글 작성 화면 로딩
 * /bbs/write/do .. 글 작성하기
 */
@Controller
@RequestMapping("/bbs")
public class BbsController {
    @Autowired
    private BbsService service;

    /**
     * \
     * 전체보기
     *
     * @return
     */
    @RequestMapping("")
    public ModelAndView viewAll() {

        /*bbs .. 전체보기*/
        //전체보기를 하기 위한 데이터를 가져온다.
        List<Article> list = service.getArticles();

        System.out.println(list);

        return new ModelAndView("bbs/view_all")
                .addObject("list", list);
    }

    /**
     * 글 전체보기 API버전
     * /bbs/api.. 전체보기(API)
     *
     * 1. @ResponseBody
     * 2. 리턴타입을 List<Article>을 리턴한다. 그러면 JSON으로 변환해 줄 것이다.
     */
    @RequestMapping("/api")
    @ResponseBody
    public List<Article> viewAllApi() {
        //전체보기를 위한 데이터를 가져온다.
        return service.getArticles();
    }

    /**
     * 글 상세보기
     *
     * @param articleId
     */
    @RequestMapping("/{articleId}")
    @ResponseBody
    public ModelAndView viewDetail(@PathVariable String articleId)/*(@PathVariable("articleId") String articleId)*/ {

        Article article = service.viewArticle(articleId);
        return new ModelAndView("bbs/view_detail")
                .addObject("article", article);
    }

    @RequestMapping("/{articleId}/api")
    public Article viewDetailApi(@PathVariable String articleId) {

        Article article = service.viewArticle(articleId);

        return article;

    }

    /**
     * 글쓰기 화면 보기
     */
    @GetMapping("/write")
    public String write() {
        return "bbs/write";
    }


    /**
     * 실제 글쓰기
     *
     * @param article
     */
    @PostMapping("/write")
    public ModelAndView doWrite(Article article) {

        System.out.println(article);

        service.registArticle(article);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("bbs/do_write");
        mav.addObject("article", article);

        return mav;
    }

    @PostMapping("/write/api")
    public String doWriteApi(@RequestBody Article article) {
        service.registArticle(article);
        return "/bbs/view_all";
    }

    //    @RequestMapping("/write/do")
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
