package com.example.p1board.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num; // 글번호

    @ManyToOne
    @JoinColumn(name = "board_userid",nullable = false)
    private MemberModel id;
    private String title;//글제목
    private String content;//글내용
}
