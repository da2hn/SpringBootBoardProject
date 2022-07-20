package com.example.board.service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public List<BoardVO> getList(Criteria criteria);
    public void register(BoardVO boardVO);
    public BoardVO get(Long boardNumber);
    public void modify(BoardVO boardVO);
    public boolean remove(Long boardNumber);
    public int getTotal(Criteria criteria);
}

