package solux.woodong.web.domain.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubUser.ClubUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean notice_auth;

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<ClubRole> clubRoles = new ArrayList<>();

    @Builder
    public Roles(String name, boolean notice_auth) {
        this.name = name;
        this.notice_auth = notice_auth;
    }

    public void update(String name, boolean notice_auth) {
        this.name = name;
        this.notice_auth = notice_auth;
    }
}
