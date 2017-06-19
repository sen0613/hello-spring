package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Amigo;
import kr.re.kitri.hello.service.AmigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * /api/amigo             (GET) .. 전체보기
 * /api/amigo/{amigoName} (GET) .. 상세보기
 * /api/amigo             (POST) .. 글쓰기
 * /api/amgio/{amigoName} (PUT) .. 글 수정
 * /api/amgio/{amigoName} (DELETE) .. 글 삭제
 */
@RestController
@RequestMapping("/api/amigo")
public class ApiAmigoController {
    @Autowired
    private AmigoService service;

    @GetMapping("")
    public List<Amigo> viewAll() {
        return service.getAmigos(); //TODO
    }

    @GetMapping("/{amigoName}")
    public Amigo viewDetail(@PathVariable String amigoName) {
        Amigo amigo = service.viewAmigo(amigoName);
        return amigo; //TODO
    }

    @PostMapping("")
    public void regist(@RequestBody Amigo amigo) {
        service.registAmigo(amigo);

    }

    @PutMapping("/{amigoName}")
    public void modify(@RequestBody String amigoName, @PathVariable Amigo amigo) {
        service.modifyAmigo(amigoName, amigo);


    }

    @DeleteMapping("/{amigoName}")
    public void remove(@PathVariable Amigo amigo) {
        service.removeAmigo(amigo);

    }

}
