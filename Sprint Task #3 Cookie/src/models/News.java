package models;

import java.sql.Timestamp;

public class News {
    private Long id;
    private String title;
    private String content;
    private String language;
    private Timestamp postedDate;


    public News(Long id, String title, String content, String language, Timestamp postedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.language = language;
        this.postedDate = postedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }
}
