package solux.woodong.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.posts.Post;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private int teamNumber;

    @Builder
    public PostSaveRequestDto(String title, String content, String author, int teamNumber) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.teamNumber = teamNumber;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .teamNumber(teamNumber)
                .build();
    }
}
