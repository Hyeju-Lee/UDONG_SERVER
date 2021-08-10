package solux.woodong.web.domain.clubRole;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ClubRole {
    @Id
    @Column(name = "ClubRole_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Club_Id")
    private Club club;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Role_Id")
    private Roles roles;

    @JsonIgnore
    @OneToMany(mappedBy = "clubRole")
    private List<ClubRoleUser> clubRoleUsers = new ArrayList<>();

    @Builder
    public ClubRole(Club club, Roles roles) {
        this.club = club;
        this.roles = roles;
    }


}
