package com.farid.MyBlog;

public class BlogDTO {
    private Number id;
    private String title;
    private String discription;
    private String name;
    private String img;
    private String Uimg;
    private String email;
    private int numOfLikes;
    private int numOfComments;
    private int numOfShares;
    public String blogpage;

    public BlogDTO(Number id, String title, String discription, String name, String img, String Uimg, String email, int numOfLikes, int numOfComments, int numOfShares) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.name = name;
        this.img = img;
        this.Uimg = Uimg;
        this.email = email;
        this.numOfLikes = numOfLikes;
        this.numOfComments = numOfComments;
        this.numOfShares = numOfShares;
        this.blogpage = "http://localhost:8080/Blog?id=" + id;
    }

    // Getters and setters
    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getdiscription() {
        return discription;
    }

    public void setdiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUImg() {
        return Uimg;
    }

    public void setUImg(String img) {
        this.Uimg = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public int getNumOfComments() {
        return numOfComments;
    }

    public void setNumOfComments(int numOfComments) {
        this.numOfComments = numOfComments;
    }

    public int getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(int numOfShares) {
        this.numOfShares = numOfShares;
    }
}
