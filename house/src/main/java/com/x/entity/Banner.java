package com.x.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private Integer id;
    // 图片地址
    private String url;
    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
