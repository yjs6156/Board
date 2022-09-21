package com.example.p1board.Service;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


    public BoardModel saveAllBoard(BoardModel boardModel){

        return boardRepository.save(boardModel);

    }

}
