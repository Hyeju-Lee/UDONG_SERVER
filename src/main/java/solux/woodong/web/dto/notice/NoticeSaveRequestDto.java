package solux.woodong.web.dto.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Club club;
    private User user;

    @Builder
    public NoticeSaveRequestDto(String title, String content, String author
            , Club club, User user) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.club = club;
        this.user = user;
    }

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .club(club)
                .user(user)
                .build();
    }
}
