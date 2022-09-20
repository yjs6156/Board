package com.example.p1board.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
    private String userId;
    private String password;
    private String phoneNum;
    private String email;
}
