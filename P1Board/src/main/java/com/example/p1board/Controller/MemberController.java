package com.example.p1board.Controller;


import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Service.MemberService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

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
    @RequestMapping("/myPage")//로그인페이지 접속
    public String mypage() {
        return "/member/mypage";
    }
    @RequestMapping("/edit")//회원가입페이지 접속
    public String memberedit() {
        return "/member/edit";
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
                session.setAttribute("password", memberModel.getPassword());
                session.setAttribute("phoneNum", memberModel.getPhoneNum());
                session.setAttribute("email", memberModel.getEmail());
                session.setAttribute("domType", memberModel.isDomType());

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

    @GetMapping("/deleteMember")//회원탈퇴
    public String deleteMember(long id) {
        memberService.deleteMember(id);
        return "index";
    }

    @GetMapping("/editMember")
    private String editMem(Model model, long id){
        MemberModel memberModel=memberService.getByMemberId(id);

        model.addAttribute("memberModel",memberModel);

        return "/member/edit";
    }

    @PostMapping("/editMember")
    public String editMember(long id,String userId,String password,String phoneNum,String email){

        MemberModel memberModel =memberService.getByMemberId(id);

        memberModel.setUserId(userId);
        memberModel.setPassword(password);
        memberModel.setEmail(email);
        memberModel.setPhoneNum(phoneNum);

        memberService.add(memberModel);

        return "/member/mypage";

    }


    @GetMapping("/logout") //회원 로그아웃
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



}

