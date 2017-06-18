package kr.re.kitri.hello.dao;


import kr.re.kitri.hello.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


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


    public Member updatePoint(String memberSeq) {
        String query =
                "SELECT member_seq, userid, password, email, point, join_date\n" +
                        "FROM member\n" +
                        "WHERE member_seq = ?";

        String insertQuery =
                "UPDATE member SET point = point+10\n" +
                        "WHERE member_seq = ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, memberSeq);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            Member member = new Member();
            member.setMemberSeq(rs.getInt(1));
            member.setUserId(rs.getString(2));
            member.setPassword(rs.getString(3));
            member.setEmail(rs.getString(4));
            member.setPoint(rs.getInt(5));
            member.setJoinDate(LocalDate.parse(String.valueOf(rs.getDate(6))));


            conn.close();
            return member;

        } catch (SQLException e) {
            e.printStackTrace();

            return new Member();
        }
    }
}
