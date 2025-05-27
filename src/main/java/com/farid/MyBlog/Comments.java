package com.farid.MyBlog;

import java.time.LocalDateTime;

public class Comments {
    private Long id;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private String userImg; // New field for user image

    // Constructor
    public Comments(Long id, String author, String content, LocalDateTime createdAt, String userImg) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
        this.userImg = userImg; // Initialize the new field
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserImg() {
        return userImg; // Getter for userImg
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg; // Setter for userImg
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", userImg='" + userImg + '\'' + // Include userImg in toString
                '}';
    }
}