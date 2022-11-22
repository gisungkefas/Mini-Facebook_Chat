package com.kefas.Weekeighttask.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    private String title;

    private String description;

    private String status;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    private Instant completedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

//    public Task(Long post_id, String title, String description, String status, Instant createdDate, Instant updatedDate, Instant completedDate, Users users) {
//        this.post_id = post_id;
//        this.title = title;
//        this.description = description;
//        this.status = status;
//        this.createdDate = createdDate;
//        this.updatedDate = updatedDate;
//        this.completedDate = completedDate;
//        this.user = users;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "post_id=" + post_id +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", status='" + status + '\'' +
//                ", createdDate=" + createdDate +
//                ", updatedDate=" + updatedDate +
//                ", completedDate=" + completedDate +
//                ", users=" + user +
//                '}';
//    }
}
