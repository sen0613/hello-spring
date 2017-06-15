package kr.re.kitri.hello.common;

import kr.re.kitri.hello.model.Amigo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-13.
 */
public class MockAmigo {
    public List<Amigo> getAmigos() {
        List<Amigo> list = new ArrayList<>();

        Amigo a = new Amigo();
        a.setAmigoName("김진");
        a.setCp("010-0000-0002");
        a.setEmail("j@naver.com");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("박철범");
        a.setCp("010-0000-0003");
        a.setEmail("c@naver.com");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("서희정");
        a.setCp("010-0000-0005");
        a.setEmail("h@naver.com");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("김태중");
        a.setCp("010-0000-0006");
        a.setEmail("t@naver.com");
        list.add(a);

        return list;
    }
}
