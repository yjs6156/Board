package com.example.p1board.Service;

import com.example.p1board.Model.MemberModel;
import com.example.p1board.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberModel add(MemberModel memberModel) {
        return memberRepository.save(memberModel);
    }

    public MemberModel getByMemberId(Long id){
       return memberRepository.findById(id).orElse(null);
    }


}
