package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.MemberDao;
import kr.re.kitri.hello.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danawacomputer on 2017-06-16.
 */
@Service
public class MemberService {
    /**
     * 글쓰기
     *
     * @param member
     */
    @Autowired
    private MemberDao dao;

    public void registMember(Member member) {
        dao.insertMember(memeber);
    }

    public void updatePoint(int memberSeq) {

    }


}
