package com.chanyun.entity;

import java.util.Date;

public class News {
    private Integer id;

    private String newsTitle;

    private String newsDescription;

    private String newsKeywords;

    private Integer newsType;

    private String newsImg;

    private Integer newsSort;

    private Integer newsStatus;

    private Integer newsRecommend;

    private Integer newsTempleid;

    private Date createTime;

    private String newsSource;

    private String newsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription == null ? null : newsDescription.trim();
    }

    public String getNewsKeywords() {
        return newsKeywords;
    }

    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords == null ? null : newsKeywords.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }

    public Integer getNewsSort() {
        return newsSort;
    }

    public void setNewsSort(Integer newsSort) {
        this.newsSort = newsSort;
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public Integer getNewsRecommend() {
        return newsRecommend;
    }

    public void setNewsRecommend(Integer newsRecommend) {
        this.newsRecommend = newsRecommend;
    }

    public Integer getNewsTempleid() {
        return newsTempleid;
    }

    public void setNewsTempleid(Integer newsTempleid) {
        this.newsTempleid = newsTempleid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}