package com.kefas.Weekeighttask.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItems {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    private boolean complete;

    private Instant createdDate;

    private Instant updatedDate;


    public TodoItems (String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    public TodoItems() {

    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
