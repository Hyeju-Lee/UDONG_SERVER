package solux.woodong.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdTokenSaveDto {
    private String idToken;
    @Builder
    public IdTokenSaveDto(String idToken) {
        this.idToken = idToken;
    }
}
