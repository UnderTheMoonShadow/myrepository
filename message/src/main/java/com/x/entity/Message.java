package com.x.entity;

import java.util.Date;

public class Message {
    private Integer id;
    private String username;
    private Date time;
    private String title;
    private String content;

    public Message() {
    }

    public Message(String username, Date time, String content) {
        this.username = username;
        this.time = time;
        this.content = content;
    }

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
