package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Amigo;
import kr.re.kitri.hello.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-15.
 */
@Repository
public class AmigoDao {

    @Autowired
    private DataSource dataSource;

    public void insertAmigo(Amigo amigo) {

        try {
            //1. connection 확보
            Connection conn = dataSource.getConnection();

            //2. 쿼리를 생성 - PreparedStatement 생성
            String query =
                    "insert into amigo (amigo_name, cp, email)\n" +
                            "values (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, amigo.getAmigoName());
            pstmt.setString(2, amigo.getCp());
            pstmt.setString(3, amigo.getEmail());


            pstmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 글 전체보기
     */
    public List<Amigo> selectAllAmigos() {
        String query = "SELECT amigo_name, cp, email\n" +
                "FROM amigo";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            List<Amigo> list = new ArrayList<>();
            Amigo amigo;
            while (rs.next()) {
                amigo = new Amigo();
                amigo.setAmigoName(rs.getString(1));
                amigo.setCp(rs.getString(2));
                amigo.setEmail(rs.getString(3));

                list.add(amigo);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    /**
     * 글 상세보기
     *
     * @param amigoName 친구이름
     */
    public Amigo selectAmigoByName(String amigoName) {
        String query =
                "SELECT amigo_name, cp, email\n" +
                        "FROM amigo\n" +
                        "WHERE amigo_name = ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,amigoName);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            Amigo amigo = new Amigo();
            amigo.setAmigoName(rs.getString(1));
            amigo.setCp(rs.getString(2));
            amigo.setEmail(rs.getString(3));

            conn.close();
            return amigo;

        } catch (SQLException e) {
            e.printStackTrace();

            return new Amigo();
        }
    }
    public Amigo updateAmigo (String amigoName, Amigo amigo) {
        return null;
    }
    public Amigo deleteAmigo (Amigo amigo){

        return null;}
}






