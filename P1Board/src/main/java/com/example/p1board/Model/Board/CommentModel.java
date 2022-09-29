package com.example.p1board.Model.Board;

import com.example.p1board.Model.Member.MemberModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cNum;

    private String comment;

    private long likeSystem;

    @ManyToOne
    @JoinColumn(name = "board_Id",nullable = false)
    private BoardModel num;

    @ManyToOne
    @JoinColumn(name = "board_userId",nullable = false)
    private MemberModel id;


    @CreatedDate
    private LocalDateTime createdTime;
}
