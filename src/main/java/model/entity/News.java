package model.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
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
