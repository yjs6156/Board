package com.example.p1board.Controller;


import com.example.p1board.Model.MemberModel;
import com.example.p1board.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;


    @GetMapping("/signin")//회원가입페이지 접속
    public String signin() {
        return "/member/signin";
    }

    @GetMapping("/login")//로그인페이지 접속
    public String login() {
        return "/member/login";
    }

    @PostMapping("/addMember")//회원가입페이지서 MemberModel테이블에 DB저장
    public String add(MemberModel memberModel) {
        memberService.add(memberModel);
        return "index";
    }


    @GetMapping("/getMember")
    public String get(Long id,Model model){
        MemberModel memberModel= memberService.getByMemberId(id);
        model.addAttribute("member",memberModel);

        return "redirect:/index";


    }

//    }

}
