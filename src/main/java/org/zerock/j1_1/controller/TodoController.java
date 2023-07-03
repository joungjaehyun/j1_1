package org.zerock.j1_1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.j1_1.dto.PageResponseDTO;
import org.zerock.j1_1.dto.TodoDTO;
import org.zerock.j1_1.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
//api 서버란뜻
@RequestMapping("/api/todos/")
@RequiredArgsConstructor
//CORS 해결 간단한방법1 annotation 좋은방법은 아니다.
@CrossOrigin
@Log4j2
public class TodoController {
    
    private final TodoService todoService;
    // todoList REST 방식
    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){

        return todoService.getList();
    }

    @PostMapping("")
    public TodoDTO register(@RequestBody TodoDTO todoDTO){
        log.info("register...................");
        log.info(todoDTO);
        
        return todoService.register(todoDTO);
    }
}
