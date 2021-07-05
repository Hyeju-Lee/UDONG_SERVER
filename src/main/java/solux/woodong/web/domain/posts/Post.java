package solux.woodong.web.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity     //jpa 어노테이션
public class Post extends BaseTimeEntity {  //db 테이블과 매칭될 클래스

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto_increment(기본 키의 자동 증가)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private int teamNumber;

    @Builder
    public Post(String title, String content, String author, int teamNumber) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.teamNumber = teamNumber;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
