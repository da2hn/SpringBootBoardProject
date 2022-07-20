package com.example.board.mapper;

import com.example.board.domain.vo.AttachFileVO;
import com.example.board.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AttachMapperTests {
    @Autowired
    private AttachMapper attachMapper;
    @Autowired
    private BoardMapper boardMapper;

//    @Test
//    public void insertTest(){
//        BoardVO boardVO = boardMapper.select(5221L);
//        AttachFileVO attachFileVO = new AttachFileVO();
//        attachFileVO.setFileName("uuid_테스트.txt");
//        attachFileVO.setOriginalFileName("테스트.txt");
//        attachFileVO.setUploadDirectory("2022/06/30");
//        attachFileVO.setImage(false);
//        attachFileVO.setBoardVO(boardVO);
//
//        attachMapper.insert(attachFileVO);
//    }

    @Test
    public void selectTest(){
        attachMapper.select(5222L).stream().map(fileVO -> fileVO.getFileName()).forEach(log::info);
    }
}
