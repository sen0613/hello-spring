package kr.re.kitri.hello.dao;


import kr.re.kitri.hello.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by danawacomputer on 2017-06-16.
 */
public class PostDaoJdbc implements PostDao {
    @Autowired
    private DataSource dataSource;

    /**
     * 글 입력
     */
    @Override
    public void insertPost(Post post) {
        try {
            //1. connection 확보
            Connection conn = dataSource.getConnection();

            //2. 쿼리를 생성 - PreparedStatement 생성
            String query =
                    "insert into article (title, content, write_date)\n" +
                            "values (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setDate(3, Date.valueOf(post.getWriteDate()));

            pstmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post selectPostBySeq(int postSeq) {
        return null;
    }


    /**
     * 글 상세보기
     *
     * @param postSeq
     */
    @Override
    public Post selectPostBySeq(String postSeq) {
        String query =
                "SELECT post_seq, title, content, write_date\n" +
                        "FROM post, member\n" +
                        "WHERE member.member_seq = post.member_seq";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(postSeq));
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            Post post = new Post();
            post.setPostSeq(rs.getInt(1));
            post.setTitle(rs.getString(2));
            post.setContent(rs.getString(3));
            post.setWriteDate(LocalDate.parse(String.valueOf(rs.getDate(4))));


            conn.close();
            return post;

        } catch (SQLException e) {
            e.printStackTrace();

            return new Post();
        }
    }

    /**
     * 글 전체보기
     */
    @Override
    public List<Post> selectAllPosts() {
        String query =
                "SELECT post_Seq, title, content, write_date, member_seq\n" +
                        "FROM post, member\n" +
                        "WHERE member.member_seq = post.member_seq\n" +
                        "AND post_seq = ?";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            List<Post> list = new ArrayList<>();
            Post post;
            while (rs.next()) {
                post = new Post();
                post.setPostSeq(rs.getInt(1));
                post.setTitle(rs.getString(2));
                post.setContent(rs.getString(3));
                post.setWriteDate(LocalDate.parse(rs.getString(4)));



                list.add(post);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}



