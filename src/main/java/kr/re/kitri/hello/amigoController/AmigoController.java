package kr.re.kitri.hello.amigoController;

import kr.re.kitri.hello.common.MockAmigo;
import kr.re.kitri.hello.common.MockArticle;
import kr.re.kitri.hello.model.Amigo;
import kr.re.kitri.hello.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-12.
 */
@Controller
public class AmigoController {
    @RequestMapping("/amigo")
    public ModelAndView viewAll() {
        /*bbs .. 전체보기*/
        //전체보기를 하기 위한 데이터를 가져온다.
        MockAmigo mock = new MockAmigo();
        List<Amigo> list = mock.getAmigos();


        return new ModelAndView("amigo/amigo_view_all")
                .addObject("list", list);
    }


    @RequestMapping("/amigo/{amigoName}")
    public ModelAndView viewDetail(@PathVariable("amigoName") String amigoName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/amigo/amigo_view_detail");
        mav.addObject("amigoName", amigoName);

        return mav;

    }


    @RequestMapping(value="/amigo/regist", method= RequestMethod.GET)
    public String registAmigo() {
        return "amigo/regist";
    }

    @RequestMapping(value="/amigo/regist", method= RequestMethod.POST)
    public ModelAndView doRegist (Amigo amigo) {

        System.out.println(amigo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("amigo/do_regist");

        mav.addObject("amigo", amigo);

        return mav;
    }
}
