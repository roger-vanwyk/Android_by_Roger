package android.tangleddroid.roger.news;

import java.util.ArrayList;

public class CategoriesModal {

//    Creates a variable for the category,
//    news array list and expanded boolean.
    private String newsCategory;
    private ArrayList<NewsModal> newsModalArrayList;

//    Creates a constructor
    public CategoriesModal(String newsCategory, ArrayList<NewsModal> newsModalArrayList) {
        this.newsCategory = newsCategory;
        this.newsModalArrayList = newsModalArrayList;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public ArrayList<NewsModal> getNewsModalArrayList() {
        return newsModalArrayList;
    }

    public void setNewsModalArrayList(ArrayList<NewsModal> newsModalArrayList) {
        this.newsModalArrayList = newsModalArrayList;
    }
}
