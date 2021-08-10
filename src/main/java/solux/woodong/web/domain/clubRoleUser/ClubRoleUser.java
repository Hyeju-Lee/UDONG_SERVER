package solux.woodong.web.domain.clubRoleUser;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.user.User;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ClubRoleUser {
    @Id
    @Column(name = "clubRoleUser_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ClubRole_Id")
    private ClubRole clubRole;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @Builder
    public ClubRoleUser(ClubRole clubRole, User user) {
        this.clubRole = clubRole;
        this.user = user;
    }
}
