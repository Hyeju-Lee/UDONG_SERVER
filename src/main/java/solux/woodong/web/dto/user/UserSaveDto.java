package solux.woodong.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class UserSaveDto {
    private String name;
    private String email;

    @Builder
    public UserSaveDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
