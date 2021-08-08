package solux.woodong.web.dto.clubUser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClubUserUpdateDto {
    private int teamNumber;

    @Builder
    public ClubUserUpdateDto(int teamNumber) {
        this.teamNumber = teamNumber;
    }
}
