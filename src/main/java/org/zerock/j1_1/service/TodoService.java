package org.zerock.j1_1.service;

import org.springframework.transaction.annotation.Transactional;

import org.zerock.j1_1.dto.PageResponseDTO;
import org.zerock.j1_1.dto.TodoDTO;

@Transactional
public interface TodoService {
    //CRUD
    PageResponseDTO<TodoDTO> getList();
    TodoDTO register(TodoDTO dto);
}
