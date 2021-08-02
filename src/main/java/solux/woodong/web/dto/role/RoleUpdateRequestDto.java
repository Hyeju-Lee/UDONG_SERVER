package solux.woodong.web.dto.role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoleUpdateRequestDto {
    private String name;
    private boolean notice_auth;

    @Builder
    public RoleUpdateRequestDto(String name, boolean notice_auth) {
        this.name = name;
        this.notice_auth = notice_auth;
    }
}
