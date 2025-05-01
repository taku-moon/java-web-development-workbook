package com.example.javawebdevelopmentworkbook.ch1.todo.service;

import com.example.javawebdevelopmentworkbook.ch1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG.........." + todoDTO);
    }

    public TodoDTO get(long tno) {

        TodoDTO dto = new TodoDTO();

        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

    public List<TodoDTO> getList() {

        return IntStream.range(0, 9)
                .mapToObj(i -> { TodoDTO dto = new TodoDTO();
                    dto.setTno((long) i);
                    dto.setTitle("Todo.." + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).toList();
    }
}
