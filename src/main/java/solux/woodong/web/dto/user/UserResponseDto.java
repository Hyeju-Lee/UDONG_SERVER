package solux.woodong.web.dto.user;

import lombok.Getter;
import solux.woodong.web.domain.user.User;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
