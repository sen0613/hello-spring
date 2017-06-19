package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * /api/bbs             (GET) .. 전체보기
 * /api/bbs/{articleId} (GET) .. 상세보기
 * /api/bbs             (POST) .. 글쓰기
 * /api/bbs/{articleId} (PUT) .. 글 수정
 * /api/bbs/{articleId} (DELETE) .. 글 삭제
 */
@RestController
@RequestMapping("/api/bbs")
public class ApiBbsController {
    @Autowired
    private BbsService service;

    @GetMapping("")
    public List<Article> viewAll() {
        return service.getArticles(); //TODO
    }

    @GetMapping("/{articleId}")
    public Article viewDetail(@PathVariable String articleId) {
        Article article = service.viewArticle(articleId); //TODO
        return article;
    }

    @PostMapping("")
    public String regist(@RequestBody Article article) {
        service.registArticle(article);
        return "/bbs/view_all";

    }

    @PutMapping("/{articleId}/do_write")
    public void modify(@PathVariable String articleId, @RequestBody Article article) {
        service.modifyArticle(articleId, article);
        return "/bbs/do_write";


    }

    @DeleteMapping("/{articleId}/do_write")
    public void remove(@PathVariable Article article) {
        service.removeArticle(article);
        return "/bbs/do_write";

    }
}
