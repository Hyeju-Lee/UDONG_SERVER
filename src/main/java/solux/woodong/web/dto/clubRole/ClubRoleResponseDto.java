package solux.woodong.web.dto.clubRole;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.role.Roles;

@Getter
public class ClubRoleResponseDto {
    private Long id;
    private Club club;
    private Roles roles;

    public ClubRoleResponseDto(ClubRole entity) {
        this.id = entity.getId();
        this.club = entity.getClub();
        this.roles = entity.getRoles();
    }
}
