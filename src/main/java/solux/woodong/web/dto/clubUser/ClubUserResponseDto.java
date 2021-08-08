package solux.woodong.web.dto.clubUser;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.user.User;

@Getter
public class ClubUserResponseDto {
    private Long id;
    private User user;
    private Club club;
    private int teamNumber;

    public ClubUserResponseDto(ClubUser entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.club = entity.getClub();
        this.teamNumber = entity.getTeamNumber();
    }
}
