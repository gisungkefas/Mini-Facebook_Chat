package com.kefas.Weekeighttask.configuration;

import com.kefas.Weekeighttask.entity.TodoItems;
import com.kefas.Weekeighttask.repository.TodoItemsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class TodoDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoDataLoader.class);

    TodoItemsRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItems todoItem1 = new TodoItems("get the milk");
            TodoItems todoItem2 = new TodoItems("rake the leaves");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }


}
