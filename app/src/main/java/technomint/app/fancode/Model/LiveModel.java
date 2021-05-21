package technomint.app.fancode.Model;

public class LiveModel {

    int liveImage;
    String eye_countlive;
    String cskvsmi;


    public LiveModel(int liveImage, String eye_countlive, String cskvsmi) {
        this.liveImage = liveImage;
        this.eye_countlive = eye_countlive;
        this.cskvsmi = cskvsmi;
    }

    public String getEye_countlive() {
        return eye_countlive;
    }

    public void setEye_countlive(String eye_countlive) {
        this.eye_countlive = eye_countlive;
    }

    public String getCskvsmi() {
        return cskvsmi;
    }

    public void setCskvsmi(String cskvsmi) {
        this.cskvsmi = cskvsmi;
    }

    public int getLiveImage() {
        return liveImage;
    }

    public void setLiveImage(int liveImage) {
        this.liveImage = liveImage;
    }
}
