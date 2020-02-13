package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Zhihu implements Serializable {
    @Id
    private Integer autoincrement;

    private String author;

    @Column(name = "answers_url")
    private String answersUrl;

    private String id;

    @Column(name = "url_token")
    private String urlToken;

    private String name;

    private String url;

    private String headline;

    private static final long serialVersionUID = 1L;

    /**
     * @return autoincrement
     */
    public Integer getAutoincrement() {
        return autoincrement;
    }

    /**
     * @param autoincrement
     */
    public void setAutoincrement(Integer autoincrement) {
        this.autoincrement = autoincrement;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return answers_url
     */
    public String getAnswersUrl() {
        return answersUrl;
    }

    /**
     * @param answersUrl
     */
    public void setAnswersUrl(String answersUrl) {
        this.answersUrl = answersUrl;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return url_token
     */
    public String getUrlToken() {
        return urlToken;
    }

    /**
     * @param urlToken
     */
    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", autoincrement=").append(autoincrement);
        sb.append(", author=").append(author);
        sb.append(", answersUrl=").append(answersUrl);
        sb.append(", id=").append(id);
        sb.append(", urlToken=").append(urlToken);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", headline=").append(headline);
        sb.append("]");
        return sb.toString();
    }
}