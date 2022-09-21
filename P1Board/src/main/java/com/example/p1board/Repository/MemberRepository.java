package com.example.p1board.Repository;

import com.example.p1board.Model.Member.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel,Long> {

    ArrayList<MemberModel> findByUserId(String userId);

}
