package caseStudy.BlogBack.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogid;

    private String blogname;
    private String blogimage;
    @Column(length = 1000000)
    private String blogdetail;
    private String blogheading;
    private String website;

    @Column(nullable = false)
    private LocalDate date;

    private int likes;
    private int dislikes;

    private String category;
    private String access;

    @ManyToOne
    private Users users;

    public Blog(String blogname, String blogimage, String blogdetail, String blogheading, String website, LocalDate date, int likes, int dislikes, String category, String access, Users users) {
        this.blogname = blogname;
        this.blogimage = blogimage;
        this.blogdetail = blogdetail;
        this.blogheading = blogheading;
        this.website = website;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
        this.category = category;
        this.access = access;
        this.users = users;
    }

    //    public Blog(String blogname, String blogimage, String blogdetail, String blogheading, LocalDate date, int likes, int dislikes, String category, String access, Users users, String website) {
//        this.blogname = blogname;
//        this.blogimage = blogimage;
//        this.blogdetail = blogdetail;
//        this.blogheading = blogheading;
//        this.date = date;
//        this.likes = likes;
//        this.dislikes = dislikes;
//        this.category = category;
//        this.access = access;
//        this.users = users;
//        this.website= website;
//    }

    public Blog() {
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getBlogimage() {
        return blogimage;
    }

    public void setBlogimage(String blogimage) {
        this.blogimage = blogimage;
    }

    public String getBlogdetail() {
        return blogdetail;
    }

    public void setBlogdetail(String blogdetail) {
        this.blogdetail = blogdetail;
    }

    public String getBlogheading() {
        return blogheading;
    }

    public void setBlogheading(String blogheading) {
        this.blogheading = blogheading;
    }

    public LocalDate getDate(){

        return date;
    }

    public void setDate(Date date) {
        this.date = LocalDate.now();
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
