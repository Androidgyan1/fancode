package technomint.app.fancode.Model;

public class NewsFragmentModel {

    int news_image;
    String title_min;
    String news_title;
    String descripation_news;

    public NewsFragmentModel() {
        this.news_image = news_image;
        this.title_min = title_min;
        this.news_title = news_title;
        this.descripation_news = descripation_news;
    }


    public int getNews_image() {
        return news_image;
    }

    public void setNews_image(int news_image) {
        this.news_image = news_image;
    }

    public String getTitle_min() {
        return title_min;
    }

    public void setTitle_min(String title_min) {
        this.title_min = title_min;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getDescripation_news() {
        return descripation_news;
    }

    public void setDescripation_news(String descripation_news) {
        this.descripation_news = descripation_news;
    }
}
