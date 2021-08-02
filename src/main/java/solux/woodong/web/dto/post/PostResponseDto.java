package solux.woodong.web.dto.post;

import lombok.Getter;
import solux.woodong.web.domain.BaseTimeEntity;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.posts.Post;

import java.time.LocalDateTime;


@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int teamNumber;
    private Club club;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.teamNumber = entity.getTeamNumber();
        this.club = entity.getClub();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
