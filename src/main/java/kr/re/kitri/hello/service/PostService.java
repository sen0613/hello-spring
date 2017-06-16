package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.MemberDao;
import kr.re.kitri.hello.dao.PostDao;
import kr.re.kitri.hello.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danawacomputer on 2017-06-16.
 */
@Service
public class PostService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PostDao dao; //Interface이름으로 autowired를 건다.

    /**
     * 글을 등록하고, 멤버에게 포인트를 10점 준다.
     * @param post
     */
    public void registPost(Post post) {
        dao.insertPost(post);
        memberDao.updatePoint(post.getMemberSeq());
    }

    /**
     * 상세글 보기
     * @param postSeq
     * @return 글
     */
    public Post viewPost(String postSeq) {

        return dao.selectPostBySeq(PostSeq);
    }
    /**
     * 전체글 보기*/
    public List<Post> getPosts() {
        return dao.selectAllPosts();}
}
