package com.kefas.Weekeighttask.controllers;

import com.kefas.Weekeighttask.entity.TodoItems;
import com.kefas.Weekeighttask.repository.TodoItemsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class TodoFromController {

    private TodoItemsRepository todoItemRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItems todoItem){
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItems todoItems = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItems);
        return "updateItems";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItems todoItems = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoItemRepository.delete(todoItems);
        return "redirect:/";
    }
}
