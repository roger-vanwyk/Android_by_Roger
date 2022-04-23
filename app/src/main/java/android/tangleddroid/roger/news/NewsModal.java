package android.tangleddroid.roger.news;

public class NewsModal {

//    String for news title, description and image
    private String newsTitle;
    private String newsDescription;
    private String newsImage;

//    Creates a constructor
    public NewsModal(String newsTitle, String newsDescription, String newsImage) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsImage = newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
