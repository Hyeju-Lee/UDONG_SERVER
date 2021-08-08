package solux.woodong.web.domain.club;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.receipt.Receipt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Club {
    @Id
    @Column(name = "Club_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int generation;

    @Column(columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false)
    private String clubCode;

    @JsonManagedReference
    @OneToMany (mappedBy = "club")
    private List<Notice> notices = new ArrayList<Notice>();

    @JsonManagedReference
    @OneToMany (mappedBy = "club")
    private List<Post> posts = new ArrayList<>();

    @JsonManagedReference
    @OneToMany (mappedBy = "club")
    private List<Receipt> receipts = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "club")
    private List<ClubUser> clubUsers = new ArrayList<>();

    @Builder
    public Club(String name, int generation, String info, String clubCode) {
        this.name = name;
        this.generation = generation;
        this.info = info;
        this.clubCode = clubCode;
    }
}
