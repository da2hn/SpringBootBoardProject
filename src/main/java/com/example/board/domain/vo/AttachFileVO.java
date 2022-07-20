package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AttachFileVO {
    private String fileName;
    private String originalFileName;
    private String uploadDirectory;
    private boolean image;
//    다대일
    private BoardVO boardVO;
}
