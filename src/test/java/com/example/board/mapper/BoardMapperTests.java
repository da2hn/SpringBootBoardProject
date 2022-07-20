package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

//    @Test
//    public void insertTest(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBoardTitle("새롭게 추가된 게시글 제목1");
//        boardVO.setBoardContent("새롭게 추가된 게시글 내용1");
//        boardVO.setBoardWriter("new1");
//        boardMapper.insert(boardVO);
//        log.info("추가된 게시글 번호 : " + boardVO.getBoardNumber());
//    }

//    @Test
//    public void selectTest(){
//        log.info(boardMapper.select(2561L).toString());
//    }

//    @Test
//    public void updateTest(){
//        BoardVO boardVO = boardMapper.select(2581L);
//        boardVO.setBoardTitle("수정된 게시글 제목");
//        boardVO.setBoardContent("수정된 게시글 내용");
//
//        log.info("UPDATE COUNT : " + boardMapper.update(boardVO));
//    }

//    @Test
//    public void deleteTest(){
//        log.info("DELETE COUNT : " + boardMapper.delete(2581L));
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("총 게시글 : " + boardMapper.getTotal());
//    }

}















