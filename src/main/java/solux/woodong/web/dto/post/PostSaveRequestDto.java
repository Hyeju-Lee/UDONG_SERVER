package solux.woodong.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private int teamNumber;
    private Club club;
    private User user;

    @Builder
    public PostSaveRequestDto(String title, String content, String author, int teamNumber
            , Club club, User user) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.teamNumber = teamNumber;
        this.club = club;
        this.user = user;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .teamNumber(teamNumber)
                .club(club)
                .user(user)
                .build();
    }
}
