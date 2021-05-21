package technomint.app.fancode.Model;

public class CommentryModel {

    String over_commentry;
    String over_run;
    String commentry_match;
    String commentry_matchsummary;

    public CommentryModel(String over_commentry, String over_run, String commentry_match, String commentry_matchsummary) {
        this.over_commentry = over_commentry;
        this.over_run = over_run;
        this.commentry_match = commentry_match;
        this.commentry_matchsummary = commentry_matchsummary;
    }

    public String getOver_commentry() {
        return over_commentry;
    }

    public void setOver_commentry(String over_commentry) {
        this.over_commentry = over_commentry;
    }

    public String getOver_run() {
        return over_run;
    }

    public void setOver_run(String over_run) {
        this.over_run = over_run;
    }

    public String getCommentry_match() {
        return commentry_match;
    }

    public void setCommentry_match(String commentry_match) {
        this.commentry_match = commentry_match;
    }

    public String getCommentry_matchsummary() {
        return commentry_matchsummary;
    }

    public void setCommentry_matchsummary(String commentry_matchsummary) {
        this.commentry_matchsummary = commentry_matchsummary;
    }
}
