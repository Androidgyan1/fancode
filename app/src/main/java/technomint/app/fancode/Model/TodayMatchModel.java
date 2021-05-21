package technomint.app.fancode.Model;

public class TodayMatchModel {
    String match_number;
    String match_time;
    String today_kkr_match;
    String today_tkr_match;
    int today_kkrimage;
    int today_tkrimage;
    String today_date;
    String today_live_match;

    public TodayMatchModel(String match_number, String match_time, String today_kkr_match, String today_tkr_match, int today_kkrimage, int today_tkrimage, String today_date, String today_live_match) {
        this.match_number = match_number;
        this.match_time = match_time;
        this.today_kkr_match = today_kkr_match;
        this.today_tkr_match = today_tkr_match;
        this.today_kkrimage = today_kkrimage;
        this.today_tkrimage = today_tkrimage;
        this.today_date = today_date;
        this.today_live_match = today_live_match;
    }

    public String getMatch_number() {
        return match_number;
    }

    public void setMatch_number(String match_number) {
        this.match_number = match_number;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getToday_kkr_match() {
        return today_kkr_match;
    }

    public void setToday_kkr_match(String today_kkr_match) {
        this.today_kkr_match = today_kkr_match;
    }

    public String getToday_tkr_match() {
        return today_tkr_match;
    }

    public void setToday_tkr_match(String today_tkr_match) {
        this.today_tkr_match = today_tkr_match;
    }

    public int getToday_kkrimage() {
        return today_kkrimage;
    }

    public void setToday_kkrimage(int today_kkrimage) {
        this.today_kkrimage = today_kkrimage;
    }

    public int getToday_tkrimage() {
        return today_tkrimage;
    }

    public void setToday_tkrimage(int today_tkrimage) {
        this.today_tkrimage = today_tkrimage;
    }

    public String getToday_date() {
        return today_date;
    }

    public void setToday_date(String today_date) {
        this.today_date = today_date;
    }

    public String getToday_live_match() {
        return today_live_match;
    }

    public void setToday_live_match(String today_live_match) {
        this.today_live_match = today_live_match;
    }
}
