package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    게시글 목록
    public List<BoardVO> getList(Criteria criteria);
//    게시글 추가
    public void insert(BoardVO boardVO);
//    게시글 한 개 가져오기
    public BoardVO select(Long boardNumber);
//    게시글 수정
    public int update(BoardVO boardVO);
//    게시글 삭제
    public int delete(Long boardNumber);
//    게시글 전체 개수
    public int getTotal(Criteria criteria);
}
