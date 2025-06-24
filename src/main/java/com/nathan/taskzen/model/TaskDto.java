package com.nathan.taskzen.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.nathan.taskzen.enums.Status;
import java.time.LocalDate;

// We can call DTO( Data transfer Object) as Bean/BussinessBean and Model also
public class TaskDto {


    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters")
    private String title;

    private String description;

    @FutureOrPresent(message = "Due Date Can't be in Past Date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;


    public TaskDto() {
    }

    public TaskDto(Long id, String title, String description, LocalDate dueDate, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Title is required") @Size(min = 3, message = "Title must be at least 3 characters") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") @Size(min = 3, message = "Title must be at least 3 characters") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}


