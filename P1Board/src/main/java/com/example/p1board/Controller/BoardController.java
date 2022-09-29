package com.example.p1board.Controller;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Model.Board.CommentModel;
import com.example.p1board.Service.BoardService;
import com.example.p1board.Service.CommentService;
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
    @Autowired
    CommentService commentService;

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

        ArrayList<BoardModel> list = boardService.getByNum(num);


        model.addAttribute("list",list.get(0));
        model.addAttribute("com",commentService.getByNum(num));

        return "/board/detail";
    }

    @GetMapping("/delete")
    public String delete(long num){
        boardService.deleteByNum(num);
        return "index";
    }

    @PostMapping("commentAdd")
    public String commentAdd(CommentModel commentModel){
        commentService.saveComment(commentModel);
        return "index";
    }
    


}
