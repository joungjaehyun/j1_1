package org.zerock.j1_1.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.j1_1.domain.Todo;
import org.zerock.j1_1.dto.PageResponseDTO;
import org.zerock.j1_1.dto.TodoDTO;
import org.zerock.j1_1.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {
    
    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;
    
    @Override
    public PageResponseDTO<TodoDTO> getList() {

        Pageable pageable = PageRequest.of(0, 20, Sort.by("tno").descending() );

        Page<Todo> result = todoRepository.findAll(pageable);
        // 실제로원하는것은 Entity를 DTO로 변환해주어야됨
        // react와 맞춰줘야된다.
        List<TodoDTO> dtoList=
        result.getContent().stream()
        .map(todo -> modelMapper.map(todo, TodoDTO.class))
        .collect(Collectors.toList());
        // PageResponseDTO에 dtoList를 담을수있게 생성
        PageResponseDTO<TodoDTO> respnose = new PageResponseDTO<>();
        // 담기
        respnose.setDtoList(dtoList);
        // Controller로 보낼값
        return respnose;
}

    @Override
    public TodoDTO register(TodoDTO dto) {
        
        // dto로 받아서 Todo entity로 변경
        Todo entity = modelMapper.map(dto, Todo.class);
        // 변경한 entity를 실제로 저장함
        Todo result = todoRepository.save(entity);

        // 저장한 entity를 다시 TodoDTO로 변경 해서 return 해줌
        return modelMapper.map(result, TodoDTO.class);
    }
}
