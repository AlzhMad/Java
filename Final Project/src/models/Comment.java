package models;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private String comment;
    private Timestamp postDate;
    private User user;
    private long newsId;

    public Comment() {
    }

    public Comment(Long id, String comment, Timestamp postDate, User user, long newsId) {
        this.id = id;
        this.comment = comment;
        this.postDate = postDate;
        this.user = user;
        this.newsId = newsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }
}


