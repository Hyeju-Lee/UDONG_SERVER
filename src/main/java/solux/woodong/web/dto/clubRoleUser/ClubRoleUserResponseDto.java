package solux.woodong.web.dto.clubRoleUser;

import lombok.Getter;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.user.User;

@Getter
public class ClubRoleUserResponseDto {
    private Long id;
    private ClubRole clubRole;
    private User user;

    public ClubRoleUserResponseDto(ClubRoleUser entity) {
        this.id = entity.getId();
        this.clubRole = entity.getClubRole();
        this.user= entity.getUser();
    }
}
