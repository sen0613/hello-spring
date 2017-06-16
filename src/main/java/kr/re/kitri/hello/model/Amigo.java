package kr.re.kitri.hello.model;

/**
 * Created by danawacomputer on 2017-06-12.
 */
public class Amigo {
    private Integer amigoId;
    private String amigoName;
    private String cp;
    private String email;

    public Amigo() {
    }

    public Integer getAmigoId() {
        return amigoId;
    }

    public void setAmigoId(Integer amigoId) {
        this.amigoId = amigoId;
    }

    public String getAmigoName() {
        return amigoName;
    }

    public void setAmigoName(String amigoName) {
        this.amigoName = amigoName;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "amigoId=" + amigoId +
                ", amigoName='" + amigoName + '\'' +
                ", cp='" + cp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
