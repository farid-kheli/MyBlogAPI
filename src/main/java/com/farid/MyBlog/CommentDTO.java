package com.farid.MyBlog;

public class CommentDTO {
    private String comment;
    private String userName;
    private String userEmail;
    private String userImage;

    public CommentDTO(String comment, String userName, String userEmail, String userImage) {
        this.comment = comment;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImage = userImage;
    }

    // Getters and setters
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
