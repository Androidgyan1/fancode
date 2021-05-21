package technomint.app.fancode.Model;

public class ScoreModel {
    String batsmen;
    String r;
    String b;
    String s4;
    String s6;
    String sr;

    public ScoreModel(String batsmen, String r, String b, String s4, String s6, String sr) {
        this.batsmen = batsmen;
        this.r = r;
        this.b = b;
        this.s4 = s4;
        this.s6 = s6;
        this.sr = sr;
    }

    public String getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(String batsmen) {
        this.batsmen = batsmen;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public String getS6() {
        return s6;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }
}
