package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardVO {
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String boardRegisterDate;
    private String boardUpdateDate;

//    일대다 관계
    private List<AttachFileVO> fileList;
}
