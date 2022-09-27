package com.example.p1board.Model.Member;

import com.example.p1board.Model.Board.BoardModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //회원 아이디

    @Column(nullable = false)
    @JsonProperty("user_id")
    private String userId;//비밇번호

    @Column(nullable = false)
    private String password;//비밇번호

    @JsonProperty("phone_num")
    private String phoneNum; //전화번호

    private String email; //이메일

    @Column(columnDefinition = "boolean default false")
    private boolean domType; //관리자, 일반회원(false)

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<BoardModel> boardModels;

}
