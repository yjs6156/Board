package com.example.p1board.Model.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequest {
    private String userId;
    private String email;
    private String password;
    private String phoneNum;
    private boolean domType;
}
