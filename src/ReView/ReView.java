package com.bitcamp.api.ReView;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class ReView {
    private Long id;
    private String title;
    private String content;
    private String writer;
    @Builder(builderMethodName = "builder")
    public ReView(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
