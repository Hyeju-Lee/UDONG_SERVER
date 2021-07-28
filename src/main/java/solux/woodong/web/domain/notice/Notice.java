package solux.woodong.web.domain.notice;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.BaseTimeEntity;
import solux.woodong.web.domain.club.Club;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Notice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Notice_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    private String author;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Club_Id")
    private Club club;


    @Builder
    public Notice(String title, String content, String author, Club club) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.club = club;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
