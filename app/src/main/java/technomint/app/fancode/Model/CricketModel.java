package technomint.app.fancode.Model;

import android.widget.ImageView;

public class CricketModel {

    String Pakistan_Super_League_T20;
    String KKR_vs_TKR;
    String KKR;
    String TKR;
    int kkrimage;
    int trinbagoimage;
    String date;
    String timekkr;


    public CricketModel(String pakistan_Super_League_T20, String KKR_vs_TKR, String KKR, String TKR, int kkrimage, int trinbagoimage, String date, String timekkr) {
        Pakistan_Super_League_T20 = pakistan_Super_League_T20;
        this.KKR_vs_TKR = KKR_vs_TKR;
        this.KKR = KKR;
        this.TKR = TKR;
        this.kkrimage = kkrimage;
        this.trinbagoimage = trinbagoimage;
        this.date = date;
        this.timekkr = timekkr;
    }

    public String getPakistan_Super_League_T20() {
        return Pakistan_Super_League_T20;
    }

    public void setPakistan_Super_League_T20(String pakistan_Super_League_T20) {
        Pakistan_Super_League_T20 = pakistan_Super_League_T20;
    }

    public String getKKR_vs_TKR() {
        return KKR_vs_TKR;
    }

    public void setKKR_vs_TKR(String KKR_vs_TKR) {
        this.KKR_vs_TKR = KKR_vs_TKR;
    }

    public String getKKR() {
        return KKR;
    }

    public void setKKR(String KKR) {
        this.KKR = KKR;
    }

    public String getTKR() {
        return TKR;
    }

    public void setTKR(String TKR) {
        this.TKR = TKR;
    }

    public int getKkrimage() {
        return kkrimage;
    }

    public void setKkrimage(int kkrimage) {
        this.kkrimage = kkrimage;
    }

    public int getTrinbagoimage() {
        return trinbagoimage;
    }

    public void setTrinbagoimage(int trinbagoimage) {
        this.trinbagoimage = trinbagoimage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimekkr() {
        return timekkr;
    }

    public void setTimekkr(String timekkr) {
        this.timekkr = timekkr;
    }
}
