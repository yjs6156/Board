package com.example.p1board.Repository;

import com.example.p1board.Model.Board.BoardModel;
import com.example.p1board.Model.Board.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel,Long> {
    ArrayList<CommentModel> findByNum(BoardModel num);
}
