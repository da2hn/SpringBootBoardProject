package com.example.board.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyDaoTests {
    @Autowired
    private ReplyDAO replyDAO;

    private Long[] arBno = {5201L, 5183L, 5182L, 5181L, 5180L};

//    @Test
//    public void registerTest(){
////        5개의 게시글에 2개씩 댓글 달기
////        람다식 사용
//        IntStream.rangeClosed(11, 20).forEach(i -> {
//            ReplyVO replyVO = new ReplyVO();
//
//            replyVO.setBoardNumber(arBno[i % 5]);
//            replyVO.setReplyContent("댓글 테스트" + i);
//            replyVO.setReplyWriter("user" + i);
//
//            replyDAO.register(replyVO);
//        });
//    }

//    @Test
//    public void readTest(){
//        log.info(replyDAO.read(20L).toString());
//    }

//    @Test
//    public void modifyTest(){
//        ReplyVO replyVO = replyDAO.read(20L);
//        replyVO.setReplyContent("수정된 댓글 내용");
//        replyDAO.modify(replyVO);
//    }

//    @Test
//    public void removeTest(){
//        replyDAO.remove(20L);
//    }

//    @Test
//    public void getListTest(){
//        replyDAO.getList(new Criteria(1, 10), 5183L).stream().map(reply -> reply.getReplyContent()).forEach(log::info);
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("COUNT : " + replyDAO.getTotal(5183L));
//    }

}
