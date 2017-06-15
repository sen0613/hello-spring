package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Amigo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/db.xml",
        "classpath:spring/applicationContext.xml"})

public class AmigoDaoTest {

    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext(
                "classpath:spring/db.xml"
                , "classpath:spring/applicationContext.xml"); // " "안에 설정 파일의 경로 적기
    }


    @Test
    public void testSelectAmigoByAmigoName() {
        AmigoDao dao = context.getBean("amigoDao", AmigoDao.class);
        Amigo amigo = dao.selectAmigoByName("김리치");
        Assert.assertTrue(amigo.getCp().equals("010-0000-0007"));
    }

    @Test
    public void testSelectAllAmigos(){
        AmigoDao dao = context.getBean("amigoDao", AmigoDao.class);
        List<Amigo> list = dao.selectAllAmigos();
        Assert.assertTrue(list.size() > 0);
        System.out.println(list.size());
        Assert.assertTrue(list.get(0).getAmigoName().equals("김세원"));
    }

    @Test
    public void testInsertAmigo() {
        AmigoDao dao = context.getBean("amigoDao", AmigoDao.class);

        Amigo amigo = new Amigo();
        amigo.setAmigoName("tc");
        amigo.setCp("000-0000-0000");
        amigo.setEmail("tc@test.com");

        dao.insertAmigo(amigo);

    }

}
