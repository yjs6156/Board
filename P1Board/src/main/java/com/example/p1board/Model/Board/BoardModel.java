package com.example.p1board.Model.Board;

import com.example.p1board.Model.Member.MemberModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num; // 글번호

    @ManyToOne
    @JoinColumn(name = "board_userid",nullable = false)
    private MemberModel id;

    private String title;//글제목

    private String content;//글내용

    @CreatedDate
    private LocalDateTime dateTime; //실시간 날짜
}
