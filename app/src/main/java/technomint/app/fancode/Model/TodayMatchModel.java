package technomint.app.fancode.Model;

public class TodayMatchModel {
    String id;
    String matchdata;
    String teamtitle1;
    String teamtitle2;
    String match_type;
    String statusmatch;
    int team1image;
    int team2image;

    public TodayMatchModel() {
        this.id = id;
        this.matchdata = matchdata;
        this.teamtitle1 = teamtitle1;
        this.teamtitle2 = teamtitle2;
        this.match_type = match_type;
        this.statusmatch = statusmatch;
        this.team1image = team1image;
        this.team2image = team2image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchdata() {
        return matchdata;
    }

    public void setMatchdata(String matchdata) {
        this.matchdata = matchdata;
    }

    public String getTeamtitle1() {
        return teamtitle1;
    }

    public void setTeamtitle1(String teamtitle1) {
        this.teamtitle1 = teamtitle1;
    }

    public String getTeamtitle2() {
        return teamtitle2;
    }

    public void setTeamtitle2(String teamtitle2) {
        this.teamtitle2 = teamtitle2;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String match_type) {
        this.match_type = match_type;
    }

    public String getStatusmatch() {
        return statusmatch;
    }

    public void setStatusmatch(String statusmatch) {
        this.statusmatch = statusmatch;
    }

    public int getTeam1image() {
        return team1image;
    }

    public void setTeam1image(int team1image) {
        this.team1image = team1image;
    }

    public int getTeam2image() {
        return team2image;
    }

    public void setTeam2image(int team2image) {
        this.team2image = team2image;
    }
}
