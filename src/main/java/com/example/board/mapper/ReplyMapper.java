package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 등록
    public void insert(ReplyVO replyVO);
//    댓글 1개 조회
    public ReplyVO select(Long replyNumber);
//    댓글 삭제
    public void delete(Long replyNumber);
//    댓글 수정
    public void update(ReplyVO replyVO);
//    댓글 목록
    public List<ReplyVO> getList(@Param("criteria") Criteria criteria, @Param("boardNumber") Long boardNumber);
//    댓글 개수
    public int getTotal(Long boardNumber);
}
