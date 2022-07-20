package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDaoTests {
    @Autowired
    private BoardDAO boardDAO;

//    @Test
//    public void getListTest(){
//        boardDAO.getList().stream().map(BoardVO::toString).forEach(log::info);
//    }

//    @Test
//    public void insertTest(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBoardTitle("새롭게 추가된 게시글 제목1");
//        boardVO.setBoardContent("새롭게 추가된 게시글 내용1");
//        boardVO.setBoardWriter("new1");
//        boardDAO.register(boardVO);
//        log.info("추가된 게시글 번호 : " + boardVO.getBoardNumber());
//    }

//    @Test
//    public void selectTest(){
//        log.info(boardDAO.findByBoardNumber(2582L).toString());
//    }

//    @Test
//    public void updateTest(){
//        BoardVO boardVO = boardDAO.findByBoardNumber(2582L);
//        boardVO.setBoardTitle("수정된 게시글 제목");
//        boardVO.setBoardContent("수정된 게시글 내용");
//
//        log.info("UPDATE : " + boardDAO.modify(boardVO));
//    }

//    @Test
//    public void deleteTest(){
//        log.info("DELETE : " + boardDAO.remove(2582L));
//    }

    @Test
    public void getTotalTest(){
        log.info("총 게시글 : " + boardDAO.getTotal(new Criteria()));
    }
}
