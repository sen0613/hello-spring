package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.AmigoDao;
import kr.re.kitri.hello.model.Amigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-15.
 */
@Service
public class AmigoService {
    @Autowired
    private AmigoDao dao;

    /**
     * 글쓰기
     *
     * @param amigo
     */
    public void registAmigo(Amigo amigo) {
        dao.insertAmigo(amigo);
    }

    /**
     * 글 전체 보기
     *
     * @return 전체 글
     */
    public List<Amigo> viewAmigos() {
        return null;
    }


    /**
     * 상세글 보기
     *
     * @param amigoName 친구이름
     * @return 글
     */

    public Amigo viewAmigo(String amigoName) {

        return dao.selectAmigoByName(amigoName);
    }

    public List<Amigo> getAmigos() {
        return dao.selectAllAmigos();
    }

    public Amigo modifyAmigo(String amigoName, Amigo amigo) {
        return dao.updateAmigo(amigoName, amigo);
    }

    public Amigo removeAmigo (Amigo amigo) {
        return dao.deleteAmigo(amigo);
    }
}
