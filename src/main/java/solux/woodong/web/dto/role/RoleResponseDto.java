package solux.woodong.web.dto.role;

import lombok.Getter;
import solux.woodong.web.domain.role.Roles;

@Getter
public class RoleResponseDto {
    private String name;
    private boolean notice_auth;

    public RoleResponseDto(Roles entity) {
        this.name = entity.getName();
        this.notice_auth = entity.isNotice_auth();
    }
}
