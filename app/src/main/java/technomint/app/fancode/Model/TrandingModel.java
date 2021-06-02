package technomint.app.fancode.Model;

import java.io.Serializable;

public class TrandingModel implements Serializable {

    int image;
    String name;
    String highlight;
    String count_eye;
    String date;
    String time_trand;
    String videoUrl;




    public TrandingModel() {
        this.videoUrl = videoUrl;
        this.image = image;
        this.name = name;
        this.highlight = highlight;
        this.count_eye = count_eye;
        this.date = date;
        this.time_trand = time_trand;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTime_trand() {
        return time_trand;
    }

    public void setTime_trand(String time_trand) {
        this.time_trand = time_trand;
    }

    public String getHighlight() {
        return highlight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public String getCount_eye() {
        return count_eye;
    }

    public void setCount_eye(String count_eye) {
        this.count_eye = count_eye;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
