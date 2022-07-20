package com.example.board.task;

import com.example.board.domain.dao.AttachDAO;
import com.example.board.domain.vo.AttachFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileCheckTask {
    private final AttachDAO attachDAO;


    /*
     *   0 * * * * * : 매 분 0초마다
     *   0/1 * * * * : 매 1초 간격
     *   0 0/1 * * * : 매 1분 간격
     *   0 0/5 * ? : 매 5분 간격
     *   0 0 0/1 * * : 매 1시간 간격
     *   0 0 0 * * ? : 매일 0시 마다
     *   0 0 0 1 * ? : 매월 1일 마다
     *   * 10-13 * * * * : 매 10, 11, 12, 13분에 동작한다.
     * */



//    매 분 0초 마다
    @Scheduled(cron = "0 * * * * *")
    public void checkFiles() throws Exception{
        log.warn("File Check Task run...............");
        log.warn("===========================================");
        List<AttachFileVO> fileList = attachDAO.getOldFiles(); // DB에서 어제 날짜의 첨부파일 전체 목록

//        DB에 저장된 경로를 따로 저장
        List<Path> fileListPaths = fileList.stream().map(file -> Paths.get("C:/upload", file.getUploadDirectory(), file.getFileName()))
                .collect(Collectors.toList());

//        이미지인지 아닌지 검사
//        이미지라면, 썸네일 파일의 이름까지도 fileListPaths에 담아준다.
        fileList.stream().filter(file -> file.isImage()).map(file -> Paths.get("C:/upload", file.getUploadDirectory(), "t_" + file.getFileName()))
                .forEach(p -> fileListPaths.add(p));

        File targeDirecotry = Paths.get("C:/upload", getDateDirectory()).toFile();

        //File객체 필드 중 listFiles()를 사용하면, 해당 경로에 있는 모든 파일들을 List로 리턴한다.
        File[] removeFiles = targeDirecotry.listFiles(file -> !fileListPaths.contains(file.toPath()));

        for(File file : removeFiles){
            file.delete();
        }
    }

    private String getDateDirectory(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        String directory = sdf.format(calendar.getTime());
        return directory;
    }
}













