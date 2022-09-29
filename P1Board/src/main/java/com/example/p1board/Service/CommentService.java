package com.example.p1board.Service;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Model.Board.CommentModel;
import com.example.p1board.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public CommentModel saveComment (CommentModel commentModel){
        return commentRepository.save(commentModel);
    }


    public ArrayList<CommentModel> getByNum(long num){

        BoardModel boardModel = new BoardModel();
        boardModel.setNum(num);

        return commentRepository.findByNum(boardModel);
    }

}
