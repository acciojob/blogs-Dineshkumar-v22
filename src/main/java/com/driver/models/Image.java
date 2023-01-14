package com.driver.models;

import javax.persistence.*;





@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Column(nullable = false)
    private String dimensions;
    public Image() {
    }
    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
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
    @ManyToOne
    @JoinColumn
    private Blog blog;
    public Blog getBlog() {

        return blog;
    }
    public void setBlog(Blog blog) {

        this.blog = blog;
    }
}