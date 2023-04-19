package models;

public class Content {
    private Long id;
    private String title;
    private String content;
    private Language language;

    public Content() {
    }

    public Content(Long id, String title, String content, Language language) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.language = language;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
