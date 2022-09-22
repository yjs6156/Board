package com.example.p1board.Model.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private long id;
    private String password;
    private String email;
    private String phoneNum;
    private String userid;
    private boolean domType;
}
