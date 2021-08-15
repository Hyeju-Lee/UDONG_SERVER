package solux.woodong.web.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.BaseTimeEntity;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.receipt.Receipt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    //@Enumerated(EnumType.STRING)
    //private Role role;

    @OneToMany (mappedBy = "user")
    private List<Notice> notices = new ArrayList<>();

    @OneToMany (mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany (mappedBy = "user")
    private List<Receipt> receipts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ClubUser> clubUsers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ClubRoleUser> clubRoleUsers = new ArrayList<>();

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        //this.role = role;
    }

    public User update(String name) {
        this.name = name;
        return this;
    }

    /*public String getRoleKey() {
        return this.role.getKey();
    }*/

}
