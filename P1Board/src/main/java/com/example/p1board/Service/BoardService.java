package com.example.p1board.Service;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


    public BoardModel saveBoard(BoardModel boardModel){
        return boardRepository.save(boardModel);
    }

    public ArrayList<BoardModel> getAll(){
        return (ArrayList<BoardModel>) boardRepository.findAll();
    }

    public ArrayList<BoardModel> getByNum(long num){
        return boardRepository.findByNum(num);
    }

    public BoardModel deleteByNum(long num){
        return boardRepository.deleteByNum(num);
    }

}
