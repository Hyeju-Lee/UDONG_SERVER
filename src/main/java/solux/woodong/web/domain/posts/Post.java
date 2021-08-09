package solux.woodong.web.domain.posts;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.BaseTimeEntity;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.user.User;

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

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    private String author;

    private int teamNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Club_Id")
    private Club club;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;


    @Builder
    public Post(String title, String content, String author, int teamNumber
            , Club club, User user) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.teamNumber = teamNumber;
        this.club = club;
        this.user = user;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
