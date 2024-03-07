package board;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    @Builder(builderClassName = "builder")
    public Board(int id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}