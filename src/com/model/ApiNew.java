package com.model;

public class ApiNew {
    private Integer id;
    private String image;
    private String title;
    private String short_content;
    private String url;
    private Integer status;
    public ApiNew() {
    }


    public ApiNew(String image, String title, String short_content, String url, Integer status) {
        this.image = image;
        this.title = title;
        this.short_content = short_content;
        this.url = url;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
