package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by danawacomputer on 2017-06-16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/db.xml",
        "classpath:spring/applicationContext.xml"})
public class ArticleDaoSpringJdbcTest {

    @Autowired
    private ArticleDaoSpringJdbc articleDao;

    @Test
    public void testSelectAllArticles() {
        List<Article> list = articleDao.selectAllArticles();
        Assert.assertTrue(list.size() > 2);
    }

    @Test
    public void testSelectArticleById() {
        Article article = articleDao.selectArticleById("3");
        System.out.println();
        Assert.assertTrue(article.getArticleId().equals("3"));
    }

    @Test
    public void testInsertArticle() {
        Article article = new Article();
        article.setArticleId("8");
        article.setTitle("tc");
        article.setAuthor("Kim");
        article.setContent("test case");
        articleDao.insertArticle(article);
    }
}
