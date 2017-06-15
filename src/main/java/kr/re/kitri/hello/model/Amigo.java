package kr.re.kitri.hello.model;

/**
 * Created by danawacomputer on 2017-06-12.
 */
public class Amigo {
    private String amigoName;
    private String cp;
    private String email;

    public Amigo() {
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "amigoName='" + amigoName + '\'' +
                ", cp='" + cp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Amigo(String amigoName, String cp, String email) {
        this.amigoName = amigoName;
        this.cp = cp;
        this.email = email;

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

}
