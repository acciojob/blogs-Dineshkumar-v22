package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String content;

    public void setId(int id) {
        this.id = id;
    }

    @CreationTimestamp
    Date pubDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("blogList")
    User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("blog")
    List<Image> imageList;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
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

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Blog(int id, String title, String content, Date pubDate, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
        this.imageList = imageList;
    }

    public Blog(int id, String title, String content, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageList = imageList;
    }

    public Blog(int id) {

        this.id = id;
    }

    public Blog(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Blog(int id, String title, String content, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.imageList = imageList;
    }
}