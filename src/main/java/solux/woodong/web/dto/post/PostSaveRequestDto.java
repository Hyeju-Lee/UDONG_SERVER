package solux.woodong.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.posts.Post;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private int teamNumber;
    private Club club;

    @Builder
    public PostSaveRequestDto(String title, String content, String author, int teamNumber, Club club) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.teamNumber = teamNumber;
        this.club = club;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .teamNumber(teamNumber)
                .club(club)
                .build();
    }
}
