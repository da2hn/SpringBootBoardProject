package com.example.board.service;

import com.example.board.domain.dao.AttachDAO;
import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.AttachFileVO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//    Service
//    여러 개의 DML을 하나의 서비스로 묶어준다.
@Service
@RequiredArgsConstructor
@Qualifier("board") @Primary
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;
    private final AttachDAO attachDAO;

    @Override
    public List<BoardVO> getList(Criteria criteria) {return boardDAO.getList(criteria);}

    @Override
//    하나의 트랜잭션에 여러 개의 DML이 있을 경우 한 개라도 오류 시 전체 ROLLBACK
    @Transactional(rollbackFor = Exception.class)
    public void register(BoardVO boardVO) {
        boardDAO.register(boardVO);
        if(boardVO.getFileList() != null){
            boardVO.getFileList().forEach(fileVO -> {
                fileVO.setBoardVO(boardVO);
                attachDAO.save(fileVO);
            });
        }
    }

    @Override
    public BoardVO get(Long boardNumber) {
        BoardVO boardVO = boardDAO.findByBoardNumber(boardNumber);
        boardVO.setFileList(attachDAO.findByBoardNumber(boardNumber));
        return boardVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(BoardVO boardVO) {
        boardDAO.modify(boardVO);
        attachDAO.remove(boardVO.getBoardNumber());
        if(boardVO.getFileList() != null){
            boardVO.getFileList().forEach(fileVO -> {
                fileVO.setBoardVO(boardVO);
                attachDAO.save(fileVO);
            });
        }
    }

    @Override
    public boolean remove(Long boardNumber) {
        return boardDAO.remove(boardNumber);
    }

    @Override
    public int getTotal(Criteria criteria) {
        return boardDAO.getTotal(criteria);
    }
}
