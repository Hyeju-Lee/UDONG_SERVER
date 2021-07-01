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
    @Builder
    public PostSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
