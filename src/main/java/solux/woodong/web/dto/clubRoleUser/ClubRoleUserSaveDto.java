package solux.woodong.web.dto.clubRoleUser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class ClubRoleUserSaveDto {
    private ClubRole clubRole;
    private User user;

    @Builder
    public ClubRoleUserSaveDto(ClubRole clubRole, User user) {
        this.clubRole = clubRole;
        this.user = user;
    }

    public ClubRoleUser toEntity() {
        return ClubRoleUser.builder()
                .clubRole(clubRole)
                .user(user)
                .build();
    }
}
