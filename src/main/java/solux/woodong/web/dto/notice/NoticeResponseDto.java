package solux.woodong.web.dto.notice;

import lombok.Getter;
import solux.woodong.web.domain.notice.Notice;

@Getter
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
