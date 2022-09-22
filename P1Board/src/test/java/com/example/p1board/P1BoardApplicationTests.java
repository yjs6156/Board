package com.example.p1board;

import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Repository.MemberRepository;
import com.example.p1board.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P1BoardApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    MemberService memberService;

    @Test
    void contextLoads() {

    }

}
