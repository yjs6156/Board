package com.example.p1board.Controller;


import com.example.p1board.Model.MemberModel;
import com.example.p1board.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/addmember")
    public String add(MemberModel memberModel){
        memberService.add(memberModel);
        return "index";

    }


}
