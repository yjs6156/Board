package com.example.p1board.Controller;


import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;


    @RequestMapping("/signin")//회원가입페이지 접속
    public String signin() {
        return "/member/signin";
    }

    @RequestMapping("/login")//로그인페이지 접속
    public String login() {
        return "/member/login";
    }

    @PostMapping("/addMember")//회원가입페이지서 MemberModel테이블에 DB저장
    public String add(MemberModel memberModel) {
        memberService.add(memberModel);
        return "index";
    }

//    @PostMapping("/userLogin")
//    public MemberModel userLogin(String userId){
//        ArrayList<MemberModel> memberModel= memberService.getByMemberUserId(userId);
//
//    }




}


