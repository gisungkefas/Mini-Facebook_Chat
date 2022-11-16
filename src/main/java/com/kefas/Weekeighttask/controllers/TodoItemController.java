package com.kefas.Weekeighttask.controllers;


import com.kefas.Weekeighttask.entity.TodoItems;
import com.kefas.Weekeighttask.repository.TodoItemsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;

@Controller
@AllArgsConstructor
public class TodoItemController {

    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    private TodoItemsRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItems todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addItems";
        }

        todoItem.setCreatedDate(Instant.now());
        todoItem.setUpdatedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItems todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "updateItems";
        }

        todoItem.setUpdatedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
