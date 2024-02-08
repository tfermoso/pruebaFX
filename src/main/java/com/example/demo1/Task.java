package com.example.demo1;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Task {

    private String title;
    private String description;
    private LocalDate create_date;
    private LocalDate deadline;
    private Boolean status;

    public Task(String title, String description, LocalDate create_date, LocalDate deadline, Boolean status) {
        this.title = title;
        this.description = description;
        this.create_date = create_date;
        this.deadline = deadline;
        this.status = status;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public SimpleObjectProperty getDeadline() {
        return new SimpleObjectProperty(deadline);
    }
    public LocalDate deadLine(){
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", create_date=" + create_date +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }
}
