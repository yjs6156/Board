package com.example.p1board.Controller;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping
    public String board(){
        return "/board/add";
    }
    @PostMapping("/add")
    public String add(BoardModel boardModel){
        boardService.saveBoard(boardModel);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        ArrayList<BoardModel> list = boardService.getAll();
        model.addAttribute("list",list);
        return "/board/list";
    }





}
