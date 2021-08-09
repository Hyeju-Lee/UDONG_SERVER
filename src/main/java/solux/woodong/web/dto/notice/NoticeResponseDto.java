package solux.woodong.web.dto.notice;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.user = entity.getUser();
    }
}
