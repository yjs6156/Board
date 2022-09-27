package com.example.p1board.Controller;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping
    public String board(){
        return "/board/board";
    }

    @PostMapping("/add")
    public String add(BoardModel boardModel){

        boardService.saveBoard(boardModel);

        return "/board/board";
    }





}
