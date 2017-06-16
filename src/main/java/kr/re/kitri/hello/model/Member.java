package kr.re.kitri.hello.model;

import java.time.LocalDate;

/**
 * Created by danawacomputer on 2017-06-16.
 */
public class Member {
    private int memberSeq;
    private String userId;
    private String password;
    private String email;
    private int point;
    private LocalDate joinDate;

    public Member() {
    }

    public Member(int memberSeq, String userId, String password, String email, int point, LocalDate joinDate) {
        this.memberSeq = memberSeq;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.point = point;
        this.joinDate = joinDate;
    }

    public int getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(int memberSeq) {
        this.memberSeq = memberSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberSeq=" + memberSeq +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                ", joinDate=" + joinDate +
                '}';
    }
}
