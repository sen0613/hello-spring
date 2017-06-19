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
    private PostDao postDao; //Interface이름으로 autowired를 건다.

    /**
     * 글을 등록하고, 멤버에게 포인트 10점을 준다.
     * @param post
     */
    public void registPost(Post post) {
        postDao.insertPost(post);
        memberDao.updatePoint(post.getMemberSeq());
    }

    public Post viewPost(String postSeq) {

        return postDao.selectPostBySeq(postSeq);
    }

    public List<Post> getPosts() {
        return postDao.selectAllPosts();}
}
