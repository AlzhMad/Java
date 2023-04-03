package models;

import java.util.Date;

public class Task {
    private Long id;
    private String name;
    private String description;
    private String deadlineDate;
    private Boolean isDone;

    public Task() {

    }

    public Task(Long id, String name, String description, String deadlineDate, Boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getIsDone() {
        if(isDone){
            return "YES";
        }
        return "NO";
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
