package com.example.board.domain.dao;

import com.example.board.domain.vo.AttachFileVO;
import com.example.board.mapper.AttachMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachDAO {

    private final AttachMapper attachMapper;

    public void save(AttachFileVO attachFileVO){
        attachMapper.insert(attachFileVO);
    }

    public List<AttachFileVO> findByBoardNumber(Long boardNumber){
        return attachMapper.select(boardNumber);
    }

    public void remove(Long boardNumber){
        attachMapper.delete(boardNumber);
    }

    public List<AttachFileVO> getOldFiles(){
        return attachMapper.getOldFiles();
    }
}
