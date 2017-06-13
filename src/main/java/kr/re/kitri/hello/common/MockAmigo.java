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
        a.setAmigoName("허민");
        a.setCp("1");
        a.setEmail("1");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("김세원");
        a.setCp("2");
        a.setEmail("2");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("김태준");
        a.setCp("3");
        a.setEmail("3");
        list.add(a);

        a = new Amigo();
        a.setAmigoName("황순성");
        a.setCp("4");
        a.setEmail("4");
        list.add(a);

        return list;
    }
}
