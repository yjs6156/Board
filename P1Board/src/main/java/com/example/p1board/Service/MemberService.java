package com.example.p1board.Service;

import com.example.p1board.Model.Member.MemberModel;
import com.example.p1board.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberModel add(MemberModel memberModel) {

        return memberRepository.save(memberModel);
    }

    public MemberModel getByMemberId(long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public ArrayList<MemberModel> getByMemberUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    public MemberModel deleteMember(long id){
        memberRepository.deleteById(id);
        return null;
    }


}
