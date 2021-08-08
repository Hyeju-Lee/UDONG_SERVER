package solux.woodong.web.dto.clubUser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class ClubUserSaveDto {
    private User user;
    private Club club;
    private int teamNumber;

    @Builder
    public ClubUserSaveDto(User user, Club club, int teamNumber) {
        this.user = user;
        this.club = club;
        this.teamNumber = teamNumber;
    }

    public ClubUser toEntity() {
        return ClubUser.builder()
                .user(user)
                .club(club)
                .teamNumber(teamNumber)
                .build();
    }
}
