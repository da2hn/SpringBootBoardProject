package com.example.board.domain.dao;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {

    private final ReplyMapper replyMapper;

    //    댓글 등록
    public void register(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }
    //    댓글 1개 조회
    public ReplyVO read(Long replyNumber){
        return replyMapper.select(replyNumber);
    }
    //    댓글 삭제
    public void remove(Long replyNumber){
        replyMapper.delete(replyNumber);
    }
    //    댓글 수정
    public void modify(ReplyVO replyVO){
        replyMapper.update(replyVO);
    }
    //    댓글 목록
    public List<ReplyVO> getList(Criteria criteria, Long boardNumber){
        return replyMapper.getList(criteria, boardNumber);
    }
    //    댓글 개수
    public int getTotal(Long boardNumber){
        return replyMapper.getTotal(boardNumber);
    }
}
