package com.kefas.Weekeighttask.repository;

import com.kefas.Weekeighttask.entity.TodoItems;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsRepository extends CrudRepository<TodoItems, Long> {
}
