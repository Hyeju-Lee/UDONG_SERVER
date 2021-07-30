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
    private String clubCode;

    @Builder
    public ClubSaveRequestDto(String name, int generation, String info, String clubCode) {
        this.name = name;
        this.generation = generation;
        this.info = info;
        this.clubCode = clubCode;
    }

    public Club toEntity() {
        return Club.builder()
                .name(name)
                .generation(generation)
                .info(info)
                .clubCode(clubCode)
                .build();
    }
}
