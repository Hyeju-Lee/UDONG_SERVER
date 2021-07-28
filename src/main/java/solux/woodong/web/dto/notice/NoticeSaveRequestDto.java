package solux.woodong.web.dto.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.notice.Notice;

@Getter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Club club;

    @Builder
    public NoticeSaveRequestDto(String title, String content, String author, Club club) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.club = club;
    }

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .club(club)
                .build();
    }
}
