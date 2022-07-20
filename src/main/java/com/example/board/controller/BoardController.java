package com.example.board.controller;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.PageDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/*
*   TASK        URL                 METHOD      PARAMETER       FORM        URL이동
*
*   전체목록    /board/list          GET         없음             없음
*   등록       /board/register      POST         모든 항목        필요          /board/list
*   조회       /board/read          GET          boardNumber     없음
*   삭제       /board/remove        POST         boardNumber     없음          /board/list
*   수정       /board/modify        POST         모든 항목        필요          /board/read
* 
* */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("register")
    public void register(){}

    @GetMapping("list")
    public String getList(Criteria criteria, Model model){
        log.info("----------------------------");
        log.info("list............. : " + criteria);
        log.info("----------------------------");

        model.addAttribute("boardList", boardService.getList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotal(criteria)));
        return "/board/list";
    }

    @PostMapping("register")
//    매개변수에 선언된 객체는 자동으로 화면에 전달되므로,
//    이를 막기 위해서는 redirect 방식의 전송이 필요하다.
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("register............. : " + boardVO);
//        boardVO.getFileList().stream().map(file -> file.getFileName()).forEach(log::info);
        log.info("----------------------------");

        boardService.register(boardVO);
//        1. Flash 사용
//         세션에 파라미터를 저장하고, request 객체가 초기화된 후 다시 request에 담아준다.
        rttr.addFlashAttribute("boardNumber", boardVO.getBoardNumber());

//        2. 쿼리 스트링
//        rttr.addAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/board/list");
    }

//    게시글 상세보기
    @GetMapping({"read", "modify"})
    public void read(Long boardNumber, Criteria criteria, HttpServletRequest req, Model model){
        log.info("----------------------------");
        log.info(req.getRequestURI() + "............. : " + boardNumber);
        log.info("----------------------------");
        model.addAttribute("board", boardService.get(boardNumber));
    }

//    수정
    @PostMapping("modify")
    public RedirectView modify(BoardVO boardVO, Criteria criteria, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("modify............. : " + boardVO);
        log.info("criteria.......... : " + criteria);
        log.info("----------------------------");
        boardService.modify(boardVO);
//        컨트롤러에서 다른 컨트롤러의 매개변수로 파라미터를 전달할 때에는
//        addAttribute(), 쿼리스트링 방식으로 전달해야 받을 수 있다.
//        Flash방식은 최종 응답 화면에서 사용될 파라미터를 전달할 때에만 사용하도록 한다.
        rttr.addAttribute("boardNumber", boardVO.getBoardNumber());
//        객체를 화면에 전달할 때에는 Flash를 사용하자.
        rttr.addFlashAttribute("criteria", criteria);
        return new RedirectView("/board/read");
    }

//    삭제
    @PostMapping("remove")
    public String remove(Long boardNumber, Criteria criteria, Model model){
        log.info("----------------------------");
        log.info("remove............. : " + boardNumber);
        log.info("----------------------------");

        boardService.remove(boardNumber);
        return getList(criteria, model);
    }
}

























