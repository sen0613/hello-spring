package kr.re.kitri.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by danawacomputer on 2017-06-09.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
    return "redirect:bbs/";
    }

    @RequestMapping("/test")
    public String test() {return "test";}
}

