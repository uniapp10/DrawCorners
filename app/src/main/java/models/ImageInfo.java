package models;

/**
 * Created by zhudongdong on 2018/5/10.
 */

public class ImageInfo {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String url;
    private String title;


    public ImageInfo(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
