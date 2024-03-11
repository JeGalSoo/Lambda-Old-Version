package com.turing.api.board;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board {
    private Long id;
    private String boardtitle;
    private String boardcontent;
    private String boardwriter;
    @Builder(builderMethodName = "builder")
    public Board(String title, String content, String writer) {
        this.boardtitle = title;
        this.boardcontent = content;
        this.boardwriter = writer;
    }
}
