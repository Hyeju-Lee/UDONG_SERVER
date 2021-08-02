package solux.woodong.web.domain.role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean notice_auth;

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
