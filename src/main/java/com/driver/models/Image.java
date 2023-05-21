package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String description;

    String dimensions;

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("imageList")
    Blog blog;

    public Image() {
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(String description, String dimensions, Blog blog) {
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public Image(int id, String description, String dimensions) {
        this.id = id;
        this.description = description;
        this.dimensions = dimensions;
    }
}