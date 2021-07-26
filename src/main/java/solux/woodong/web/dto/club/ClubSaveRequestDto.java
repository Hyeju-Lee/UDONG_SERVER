package solux.woodong.web.dto.club;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;

@Getter
@NoArgsConstructor
public class ClubSaveRequestDto {
    private String name;
    private int generation;
    private String info;

    @Builder
    public ClubSaveRequestDto(String name, int generation, String info) {
        this.name = name;
        this.generation = generation;
        this.info = info;
    }

    public Club toEntity() {
        return Club.builder()
                .name(name)
                .generation(generation)
                .info(info)
                .build();
    }
}
