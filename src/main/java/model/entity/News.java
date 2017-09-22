package model.entity;

import java.util.Date;

public class News extends Message {
    private String title;

    public News(String content, Date createAt, String title) {
        super(content, createAt);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
