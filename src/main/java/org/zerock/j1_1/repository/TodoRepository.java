package org.zerock.j1_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.j1_1.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
    
}
