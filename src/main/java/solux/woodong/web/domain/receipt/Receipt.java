package solux.woodong.web.domain.receipt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Receipt extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cost;

    private String title;

    private String content;

    private String picture;

    private String useDate;

    @Builder
    public Receipt(String cost, String title, String content, String picture, String useDate) {
        this.cost = cost;
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.useDate = useDate;
    }

    public void update(String cost, String title, String content, String picture, String useDate) {
        this.title = title;
        this.content = content;
        this.cost = cost;
        this.picture = picture;
        this.useDate = useDate;
    }

}
