package com.example.p1board.Repository;

import com.example.p1board.Model.Board.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel,Long> {
    ArrayList<BoardModel> findByNum(long num);

    @Transactional
    ArrayList<BoardModel> deleteByNum(long num);

}
