/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author bookm
 */
public class News {

    private int id;
    private String title;
    private String content;
    private String description;
    private String image;
    private Date createdDate;
    private String author;

    public News() {
    }

    public News(int id, String title, String content, String description, String image, Date createdDate, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.image = image;
        this.createdDate = createdDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateConvert() {
        System.out.println(this.createdDate);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy - hh:mm ", Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("a", Locale.ENGLISH); // get am or pm
        String date = dateFormat1.format(this.createdDate) + dateFormat2.format(this.createdDate).toLowerCase();
        return date;
    }

    @Override
    public String toString() {
        return getId() + "---" + getDateConvert();
    }

}
