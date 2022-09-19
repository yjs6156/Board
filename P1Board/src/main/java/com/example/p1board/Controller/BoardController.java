package com.example.p1board.Controller;

import com.example.p1board.Model.BoardModel;
import com.example.p1board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "index";
    }





}
