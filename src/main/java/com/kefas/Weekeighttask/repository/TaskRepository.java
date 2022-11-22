package com.kefas.Weekeighttask.repository;

import com.kefas.Weekeighttask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskByTitle(String title);
    Optional<Task> findTaskByStatus(String status);
}
