package com.example.p1board.Controller;


import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@RestController
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

    @GetMapping("/mypage/{id}")//회원가입페이지 접속
    public String mypage(@PathVariable long id) {

        MemberModel memberModel = memberService.getByMemberId(id);

        return memberModel.toString();
    }

    @PostMapping("/addMember")//회원가입페이지서 MemberModel테이블에 DB저장
    public String add(MemberModel memberModel) {
        memberService.add(memberModel);
        return "index";
    }

    @PostMapping("/memberLogin")
    public String memLogin(String uId, String pwd, HttpSession session,Model model) {
        ArrayList<MemberModel> list = memberService.getByMemberUserId(uId);
        String msg = "";
        String path ="";
        if (!list.isEmpty())
        {
            MemberModel memberModel = list.get(0);

            if (memberModel.getPassword().equals(pwd)) {
                session.setAttribute("userId", uId);
                session.setAttribute("id", memberModel.getId());
                session.setAttribute("domtype", memberModel.isDomType());

                path = "/index";
            } else {
                msg = "비밀번호가 틀렸습니다";
                path = "/member/login";

            }
        } else{
            msg = "존재하지 않는 id입니다";
            path = "/member/login";
        }

        model.addAttribute("msg",msg);

        return path;

    }

    @DeleteMapping("/deleteMember")
    public void delMember(long id){
        MemberModel memberModel = memberService.deleteMember(id);
    }
}

