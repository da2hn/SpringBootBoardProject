package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    private Long[] arBno = {5201L, 5183L, 5182L, 5181L, 5180L};

//    @Test
//    public void insertTest(){
////        5개의 게시글에 2개씩 댓글 달기
////        람다식 사용
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            ReplyVO replyVO = new ReplyVO();
//
//            replyVO.setBoardNumber(arBno[i % 5]);
//            replyVO.setReplyContent("댓글 테스트" + i);
//            replyVO.setReplyWriter("user" + i);
//
//            replyMapper.insert(replyVO);
//        });
//    }

//    @Test
//    public void selectTest(){
//        log.info(replyMapper.select(1L).toString());
//    }
    
//    @Test
//    public void updateTest(){
//        ReplyVO replyVO = replyMapper.select(1L);
//        replyVO.setReplyContent("수정된 댓글 내용");
//        replyMapper.update(replyVO);
//    }

//    @Test
//    public void deleteTest(){
//        replyMapper.delete(1L);
//    }

//    @Test
//    public void getListTest(){
//        replyMapper.getList(new Criteria(1, 10), 5201L).stream().map(reply -> reply.getReplyContent()).forEach(log::info);
//    }

    @Test
    public void getTotalTest(){
        log.info("COUNT : " + replyMapper.getTotal(5183L));
    }

}















