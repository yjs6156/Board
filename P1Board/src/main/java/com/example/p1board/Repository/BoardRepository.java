package com.example.p1board.Repository;

import com.example.p1board.Model.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface BoardRepository extends JpaRepository<BoardModel,String> {

}
