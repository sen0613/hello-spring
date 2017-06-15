package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.common.MockAmigo;
import kr.re.kitri.hello.common.MockArticle;
import kr.re.kitri.hello.model.Amigo;
import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.AmigoService;
import kr.re.kitri.hello.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import java.util.List;

/**
 * /amigo .. 친구 전체보기
 * /amigo/regist (GET) .. 친구 등록화면으로 이동
 * /amigo/regist (POST) .. 친구 등록
 * /amigo/{id} .. 친구 상세보기
 * /amigo/{id}/modify (GET) .. 친구 수정하기 화면으로 이동
 * /amigo/{id}/modify (POST) .. 친구 수정하기
 * /amigo/{id}/remove (GET) .. 친구 삭제하기
 *
 */
@Controller
@RequestMapping("/amigo")
public class AmigoController {
    @Autowired
    private AmigoService service;

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
        List<Amigo> list = service.getAmigos();

        System.out.println(list);

        return new ModelAndView("amigo/amigo_view_all")
                .addObject("list", list);
    }

    /**
     * 글 상세보기
     * @param amigoName
     */
    @RequestMapping("/{amigoName}")
    public ModelAndView viewDetail(@PathVariable("amigoName") String amigoName) {

        Amigo amigo = service.viewAmigo(amigoName);
        return new ModelAndView("amigo/amigo_view_detail")
                .addObject("amigo", amigo);

    }

    /**
     * 글쓰기 화면 보기
     */
    @GetMapping("/regist")
    public String registAmigo() {
        return "amigo/regist";
    }

    /**
     * 실제 글쓰기
     * @param amigo
     */
    @PostMapping("/regist")
    public ModelAndView doRegist(Amigo amigo) {

        System.out.println(amigo);

        service.registAmigo(amigo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("amigo/do_regist");
        mav.addObject("amigo", amigo);

        return mav;
    }

}
