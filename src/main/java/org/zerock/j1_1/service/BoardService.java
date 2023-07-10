package org.zerock.j1_1.service;

import org.zerock.j1_1.dto.BoardDTO;
import org.zerock.j1_1.dto.BoardListRcntDTO;
import org.zerock.j1_1.dto.PageRequestDTO;
import org.zerock.j1_1.dto.PageResponseDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {
    
    PageResponseDTO<BoardListRcntDTO> listRcnt (PageRequestDTO pageRequestDTO);

    BoardDTO getOne(Long bno);
}
