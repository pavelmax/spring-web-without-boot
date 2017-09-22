package model.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Comment extends Message {
    private Integer like;
    private Integer dislike;

    public Comment(String content, Date createAt) {
        super(content, createAt);
    }

    public Comment(String content, Date createAt, Integer like, Integer dislike) {
        super(content, createAt);
        this.like = like;
        this.dislike = dislike;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }
}
