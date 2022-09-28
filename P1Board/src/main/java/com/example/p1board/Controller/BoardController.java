package com.example.p1board.Controller;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list") //list 페이지 바인딩
    public String list(Model model){
        ArrayList<BoardModel> list = boardService.getAll();
        model.addAttribute("list",list);
        return "/board/list";
    }


    @GetMapping("/detail/{num}") //detail 페이지 바인딩
    public String detail(@PathVariable long num, Model model){

        ArrayList<BoardModel> list = boardService.getAll();
        model.addAttribute("list",list.get(0));


        return "/board/detail"+list.get(0).getNum();
    }

    @DeleteMapping("delete")
    public String delete(long num){

        boardService.deleteByNum(num);

        return "/board/list";
    }






}
