package solux.woodong.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.clubRole.ClubRole;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String name;

    @Builder
    public UserUpdateDto(String name) {
        this.name = name;
    }

}
