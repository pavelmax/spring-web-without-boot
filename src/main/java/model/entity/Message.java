package model.entity;

import java.util.Date;

public abstract class Message extends AbstactEntity {
    private String content;
    private Date createAt;

    public Message(String content, Date createAt) {
        this.content = content;
        this.createAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
