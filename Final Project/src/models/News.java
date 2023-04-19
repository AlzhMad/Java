package models;

import java.sql.Timestamp;

public class News {
    private Long id;
    private Content content;
    private Timestamp postedDate;
    private Category category;

    public News() {
    }

    public News(Long id, Content content, Timestamp postedDate, Category category) {
        this.id = id;
        this.content = content;
        this.postedDate = postedDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
