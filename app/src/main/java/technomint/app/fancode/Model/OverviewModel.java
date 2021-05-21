package technomint.app.fancode.Model;

public class OverviewModel {

    String overview_match;
    String overview_matchsummary;

    public OverviewModel(String overview_match, String overview_matchsummary) {
        this.overview_match = overview_match;
        this.overview_matchsummary = overview_matchsummary;
    }

    public String getOverview_match() {
        return overview_match;
    }

    public void setOverview_match(String overview_match) {
        this.overview_match = overview_match;
    }

    public String getOverview_matchsummary() {
        return overview_matchsummary;
    }

    public void setOverview_matchsummary(String overview_matchsummary) {
        this.overview_matchsummary = overview_matchsummary;
    }
}
