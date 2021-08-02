package solux.woodong.web.dto.role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.role.Roles;

@Getter
@NoArgsConstructor
public class RoleSaveRequestDto {
    private String name;
    private boolean notice_auth;

    @Builder
    public RoleSaveRequestDto(String name, boolean notice_auth) {
        this.name = name;
        this.notice_auth = notice_auth;
    }

    public Roles toEntity() {
        return Roles.builder()
                .name(name)
                .notice_auth(notice_auth)
                .build();
    }
}
