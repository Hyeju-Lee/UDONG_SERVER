package solux.woodong.web.dto.club;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.notice.Notice;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClubResponseDto {
    private Long id;
    private String name;
    private int generation;
    private String info;
    private String clubCode;
    private List<Notice> notices = new ArrayList<Notice>();

    public ClubResponseDto(Club entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.generation = entity.getGeneration();
        this.info = entity.getInfo();
        this.clubCode = entity.getClubCode();
        this.notices = entity.getNotices();
    }
}
