package solux.woodong.web.dto.clubRole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.role.Roles;

@Getter
@NoArgsConstructor
public class ClubRoleSaveDto {
    private Club club;
    private Roles roles;

    @Builder
    public ClubRoleSaveDto(Club club, Roles roles) {
        this.club = club;
        this.roles = roles;
    }

    public ClubRole toEntity() {
        return ClubRole.builder()
                .club(club)
                .roles(roles)
                .build();
    }
}
