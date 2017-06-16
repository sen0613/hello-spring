package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Amigo;
import kr.re.kitri.hello.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-16.
 */
@Repository
public class MemberDao {
    @Autowired
    private DataSource dataSource;

    public void updatePoint(int memberSeq) {
        String query =
                "insert into member(userid, password, email, join_date)\n" +
                "values (?, ?, ?, ?)";

    }

    public void insertMember(Member member) {

        try {
            //1. connection 확보
            Connection conn = dataSource.getConnection();

            //2. 쿼리를 생성 - PreparedStatement 생성
            String query =
                    "insert into member (member_seq, userid, password, email, join_date)\n" +
                            "VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setDate(4, java.sql.Date.valueOf((member.getJoinDate())));

            pstmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

//
//    public List<Member> selectAllAmigos() {
//        String query = "SELECT member_seq, userid, password, email, join_date\n" +
//                "FROM member";
//
//        Connection conn = null;
//        try {
//            conn = dataSource.getConnection();
//
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//
//            List<Member> list = new ArrayList<>();
//            Member member;
//            while (rs.next()) {
//                member = new Member();
//                member.setMemberSeq(rs.getInt(1));
//                member.setUserId(rs.getString(2));
//                member.setPassword(rs.getString(3));
//                member.setEmail(rs.getString(4));
//                member.setJoinDate(rs.getDate(5));
//
//                list.add(member);
//            }
//            conn.close();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    /**
//     * 글 상세보기
//     * @param memberSeq
//     */
//    public Member selectMemberBySeq(String memberSeq) {
//        String query =
//                "SELECT member_seq, userid, password, email, join_date\n" +
//                        "FROM member\n" +
//                        "WHERE member_seq = ?";
//
//        try {
//            Connection conn = dataSource.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1,memberSeq);
//            ResultSet rs = pstmt.executeQuery();
//            rs.next();
//
//            Member member = new Member();
//            member.setUserId(rs.getString(1));
//            member.setPassword(rs.getString(2));
//            member.setEmail(rs.getString(3));
//            member.setJoinDate(rs.getDate(4));
//
//
//            conn.close();
//            return member;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return new Member();
//        }
//    }

