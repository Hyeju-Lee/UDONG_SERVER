package solux.woodong.web.dto.club;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;

@Getter
public class ClubResponseDto {
    private Long id;
    private String name;
    private int generation;
    private String info;

    public ClubResponseDto(Club entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.generation = entity.getGeneration();
        this.info = entity.getInfo();
    }
}
